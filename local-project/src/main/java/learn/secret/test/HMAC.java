package learn.secret.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.crypto.*;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author: liutaotao
 * @date : 2017年11月3日下午2:55:00
 *
 */
/**
 *HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。
 *消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个 标识鉴别消息的完整性。
 *使用一个密钥生成一个固定大小的小数据块，即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证 等。 
 *
  HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。
     消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。
    使用一个密钥生成一个固定大小的小数据块，
    即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证等。
 */
public class HMAC {

	public static final String KEY_MAC = "HmacMD5";

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		SecretKey secretKey = keyGenerator.generateKey();
		BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encodeBuffer(secretKey.getEncoded()); 
 	}

	/**
	 * HMAC加密 ：主要方法
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptHMAC(byte[] data, String key) throws Exception {
		byte [] kd =  (new BASE64Decoder()).decodeBuffer(key) ;
		SecretKey secretKey = new SecretKeySpec(kd, KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return new String(mac.doFinal(data));

	}

	public static String getResult1(String inputStr) {
		String path = "C:\\Users\\liutaotao\\Desktop";
		String fileSource = path + "\\HMAC_key.txt";
		System.out.println("=======加密前的数据:" + inputStr);
		String result = null;
		try {
			byte[] inputData = inputStr.getBytes();
			String key = HMAC.initMacKey(); /* 产生密钥 */
			System.out.println("Mac密钥:===" + key);
			/* 将密钥写文件 */
			FileOutputStream out = new FileOutputStream(new File(fileSource));   
			out.write(key.getBytes());
			// Tools.WriteMyFile(fileSource, key);
			result = HMAC.encryptHMAC(inputData, key);
			System.out.println("HMAC加密后:===" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static String getResult2(String inputStr) {
		System.out.println("=======加密前的数据:" + inputStr);
		String path = "C:\\Users\\liutaotao\\Desktop";
		String fileSource = path + "\\HMAC_key.txt";
		String key = null;
		;
		try {
			/* 将密钥从文件中读取 */
			StringBuilder result = new StringBuilder(); 
			BufferedReader br = new BufferedReader(new FileReader(fileSource));
			String s = null;
	        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
	              result.append(System.lineSeparator()+s);
	        }
	        br.close();  
			key = result.toString();// Tools.ReadMyFile(fileSource);
			System.out.println("getResult2密钥:===" + key);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String result = null;
		try {
			byte[] inputData = inputStr.getBytes();
			/* 对数据进行加密 */
			result = HMAC.encryptHMAC(inputData, key);
			System.out.println("HMAC加密后:===" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void main(String args[]) {
		try {
			String inputStr = "简单加密";
			/* 使用同一密钥：对数据进行加密：查看两次加密的结果是否一样 */
			getResult1(inputStr);
			getResult2(inputStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
// 06cVeozxxHmjXvTWh+ROF8fl8/OVmw+EBxyxjmCh+vXXHirZyHoAUs9gnGyeSsdbmbYZlSxCPU/6IAl6fJfJKw==
	}
}
