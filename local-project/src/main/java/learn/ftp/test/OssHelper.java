package learn.ftp.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.DownloadFileRequest;
import com.aliyun.oss.model.DownloadFileResult;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import lombok.extern.slf4j.Slf4j;

/**
 * OSS工具类
 * 
 * @author yanglei
 * @date 2017/12/05 14:18:47
 */
@Slf4j
public class OssHelper{
	private OSSClient client = null;
	private String bucket;
	private Boolean isCloseable;
	private Integer taskNum = 5;
	
	/**
	 * @param taskNum the taskNum to set
	 */
	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}

	/**
	 * @param client
	 */
	public OssHelper(OSSClient client, String bucket, Boolean isCloseable) {
		super();
		this.client = client;
		this.bucket = bucket;
		this.isCloseable = isCloseable;
	}

	/**
	 * OSS文件上传方法
	 * 
	 * @param filePath
	 *            文件的本地路径
	 * @param ossPath
	 *            oss路径
	 * @return
	 * @throws Exception
	 */
	public String upload(String filePath, String ossPath) throws Exception {
		try {
			byte[] buff = IOUtils.toByteArray(new FileInputStream(filePath));
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(buff.length);
			meta.setContentEncoding("UTF-8");
			PutObjectResult result = client.putObject(bucket, ossPath, new ByteArrayInputStream(buff), meta);
			if (StringUtils.isBlank(result.getETag())) {
				throw new RuntimeException("oss upload fail!");
			}
			log.debug("OSS文件上传成功! Etag: {} 路径: ", result.getETag(), ossPath);
			return ossPath;
		} catch (Exception e) {
			throw e;
		} finally {
			if (isCloseable) {
				client.shutdown();
			}
		}
	}

	/**
	 * OSS 批量删除方法
	 * 
	 * @param keys
	 *            oss文件路径集合
	 * @return
	 * @throws Exception
	 */
	public boolean delete(List<String> keys) throws Exception {
		try {
			DeleteObjectsResult deleteObjectsResult = client
					.deleteObjects(new DeleteObjectsRequest(bucket).withKeys(keys));
			List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
			return CollectionUtils.isNotEmpty(deletedObjects);
		} catch (Exception e) {
			throw e;
		} finally {
			if (isCloseable) {
				client.shutdown();
			}
		}
	}

	/**
	 * OSS文件下载
	 * 
	 * @param ossKey
	 *            oss文件路径
	 * @param destPath
	 *            下载到目标文件夹
	 * @param isFollowOssPath
	 *            是否根据oss路径创建本地同名路径
	 * @throws Throwable
	 */
	public void downLoad(String ossKey, String destPath, Boolean isFollowOssPath) throws Throwable {
		try {
			DownloadFileRequest downloadFileRequest = new DownloadFileRequest(bucket, ossKey);
			String virtualPath = destPath + File.separator + ossKey;
			String fname = FilenameUtils.getName(virtualPath);

			if (isFollowOssPath) {
				String fullPath = FilenameUtils.getFullPath(virtualPath);
				FileUtils.forceMkdir(new File(fullPath));
				downloadFileRequest.setDownloadFile(fullPath + fname);
			} else {
				FileUtils.forceMkdir(new File(destPath));
				downloadFileRequest.setDownloadFile(destPath + File.separator + fname);
			}
			// 下载请求，5个任务并发下载，启动断点续传
			downloadFileRequest.setTaskNum(taskNum);
			downloadFileRequest.setEnableCheckpoint(false);

			// 下载文件
			DownloadFileResult downloadRes = client.downloadFile(downloadFileRequest);
			// 下载成功时，会返回文件的元信息
			ObjectMetadata meta = downloadRes.getObjectMetadata();
			if (meta == null) {
				File temp = new File(downloadFileRequest.getDownloadFile());
				if(temp.exists()) {
					return;
				}
				log.error("OSS download fail! cause: {}", JSON.toJSONString(downloadFileRequest));				
				return;
			}
			log.debug("OSS文件下载成功! Etag: {} 路径: {}", meta.getETag(), downloadFileRequest.getDownloadFile());
		} catch (Throwable throwable) {
			log.error("OSS文件下载失败!", throwable);
			throwable.printStackTrace();
		} finally {
			if (isCloseable) {
				client.shutdown();
			}
		}
	}

	/**
	 * OSS文件批量下载
	 * 
	 * @param keys
	 *            oss文件路径集合
	 * @param destPath
	 *            下载到目标文件夹
	 * @param isFollowOssPath
	 *            是否根据oss路径创建本地同名路径
	 * @throws Throwable
	 */
	public void batchDownLoad(List<String> keys, String destPath, Boolean isFollowOssPath) throws Throwable {
		try {
			for (String key : keys) {
				downLoad(key, destPath, isFollowOssPath);
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		} finally {
			if (isCloseable) {
				client.shutdown();
			}
		}
	}

	/**
	 * 获取指定路径下的oss文件
	 * 
	 * @param ossPath
	 * @param destPath
	 * @param isFollowOssPath
	 * @throws Throwable
	 */
	public void batchDownLoad(String ossPath, String destPath, Boolean isFollowOssPath) throws Throwable {
		try {
			log.debug("准备批量下载, ossPath: {} destPath:{}", ossPath, destPath);
			// 分页所有获取从特定Object后的所有的Object，每页maxKeys条Object
			String nextMarker = null;
			ObjectListing objectListing = null;
			List<OSSObjectSummary> sums = null;
			do {
				objectListing = client.listObjects(
						new ListObjectsRequest(bucket).withPrefix(ossPath).withMarker(nextMarker).withMaxKeys(100));

				sums = objectListing.getObjectSummaries();
				for (OSSObjectSummary s : sums) {
					downLoad(s.getKey(), destPath, isFollowOssPath);
				}
				nextMarker = objectListing.getNextMarker();
			} while (objectListing.isTruncated());
		} catch (Exception e) {
			log.error("oss文件批量下载失败!", e);
			throw e;
		} finally {
			if (isCloseable) {
				client.shutdown();
			}
		}
	}
}
