package learn.something.test;

import java.nio.file.DirectoryStream;
import java.util.Date;

/**
 *
 * @author: liutaotao
 * @date : 2017年7月7日下午4:49:19
 *
 */
public class ClassPathTest {

	public static void main(String[] args) {
		// 取得根目录路径
		String rootPath = new ClassPathTest().getClass().getResource("/").getFile().toString();
		System.out.println(rootPath);
		Date date = new Date();
		System.out.println(date.getTime());
	}
}
