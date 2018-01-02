package learn.something.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.DirectoryStream;
import java.util.Date;
import java.util.TreeMap;

/**
 *
 * @author: liutaotao
 * @date : 2017年7月7日下午4:49:19
 *
 */
public class ClassPathTest {

	public static void main(String[] args) {
		
		TreeMap treeMap = new TreeMap<Character, Integer>();
		
		
		String  string = "I am a students";//"I am a students";
		String [] splitedStringArray = string.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = splitedStringArray.length - 1 ;i >= 0;i--){
			stringBuilder.append(splitedStringArray[i] + " ");
		}
		System.out.println(stringBuilder);
		int as = "0123456".indexOf(2);
		System.out.println(as);
		int r = 0;
		for(int i = 1;i < 100;i++){
			if((i-1)*3 + 10 > 21){
				r = i;
				break;
			}
		}
		System.out.println(r);
		
		int result = 0;
		int i = 2;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i*2;
		case 3:
			result = result + i*3;
		}
		
		System.out.println(result);
		
 
		int a = i+=i-=i*=i;
		
		System.out.println(a);
		
		// 获取本地的环境
		System.out.println(System.getenv());
		// 取得根目录路径
		String rootPath = new ClassPathTest().getClass().getResource("/").getFile().toString();
		System.out.println(rootPath);
		Date date = new Date();
		System.out.println(date.getTime());
		Long total = 100L;
		if(total > 0){
			BigDecimal t = new BigDecimal(total);
			BigDecimal c = new BigDecimal(300);
			BigDecimal v = new BigDecimal(10);
			// long result = t.multiply(v).divide(c, 0, RoundingMode.HALF_EVEN).longValue();
			// System.out.println(result);
		}
		
	}
}
