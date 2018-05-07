package learn.ftp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import aicai.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 与 ftp 类似，只是改util 不会在本地创建临时文件
 * @author fxp
 *
 */
@Slf4j
public class FtpUtils {
	/**
	 * 读取指定目录下的文件名
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 * @return
	 */
	public static List<String> getFileNameList(String ip, int port, String userName, String userPwd, String path){
		FTPClient ftpClient = connectServer(ip,port,userName,userPwd,path);
		try{
			return getFileList(ftpClient,path);
		}catch(Exception e){
			log.error(e.getMessage());
		}finally{
			closeServer(ftpClient);
		}
		return null;
	}
	
	/**
	 * 从服务器上读取指定的文件
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 * @param fileName
	 * @param strencoding
	 * @return
	 * @throws ParseException
	 */
	public static List<String> readFile(String ip, int port, String userName, String userPwd, String path,String fileName,String strencoding){
		FTPClient ftpClient = connectServer(ip,port,userName,userPwd,path);
		if(StringUtil.isEmpty(strencoding)){
			strencoding = "UTF-8";
		}
		try {
			return readFile(ftpClient, fileName, strencoding);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}finally{
			closeServer(ftpClient);
		}
		return null;
	}
	
	
	/**
	 * 读取指定目录下的文件名
	 * @param ftpClient
	 * @param path
	 * @return
	 */
	private static List<String> getFileList(FTPClient ftpClient,String path) {
		List<String> fileLists = new ArrayList<String>();
		// 获得指定目录下所有文件名
		FTPFile[] ftpFiles = null;
		try {
			ftpFiles = ftpClient.listFiles(path);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
			FTPFile file = ftpFiles[i];
			if (file.isFile()) {
				fileLists.add(file.getName());
			}
		}
		return fileLists;
	}
	
	/**
	 * 从服务器上读取指定的文件
	 * @param ftpClient
	 * @param fileName
	 * @param strencoding
	 * @return
	 * @throws ParseException
	 */
	private static List<String> readFile(FTPClient ftpClient,String fileName,String strencoding) throws ParseException {
		InputStream ins = null;
		List<String> list = null;
		try {
			// 从服务器上读取指定的文件
			ins = ftpClient.retrieveFileStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
			String line;
			list = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				if(StringUtil.isNotEmpty(line)){
					list.add(line);
				}
				
			}
			reader.close();
			if (ins != null) {
				ins.close();
			}
			// 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
			ftpClient.getReply();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return list;
	}

	/**
	 * @param fileName
	 *            function:删除文件
	 */
	public static void deleteFile(FTPClient ftpClient,String fileName) {
		try {
			ftpClient.deleteFile(fileName);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	 
	/**
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 * @throws SocketException
	 * @throws IOException
	 *             function:连接到服务器
	 */
	private static FTPClient connectServer(String ip, int port, String userName, String userPwd, String path) {
		FTPClient ftpClient = new FTPClient();
		try {
			// 连接
			ftpClient.connect(ip, port);
			// 登录
			ftpClient.login(userName, userPwd);
			if (path != null && path.length() > 0) {
				// 跳转到指定目录
				ftpClient.changeWorkingDirectory(path);
			}
			return ftpClient;
		} catch (SocketException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 关闭连接
	 * @param ftpClient
	 */
	private static void closeServer(FTPClient ftpClient) {
		if (ftpClient != null && ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}
	
}
