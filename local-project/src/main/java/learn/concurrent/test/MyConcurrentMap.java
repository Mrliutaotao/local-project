package learn.concurrent.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.AfterClass;

/**
*
* @author: liutaotao
* @date  : 2018年1月18日下午7:45:38
*
*/
public class MyConcurrentMap {
	public static void main(String [] args){ 
		ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<String, String>();
		// 首先判断初始化了没(对象数组table[]是否为null),未初始化则初始化,然后获取要放入的位置
		// 如果有值则不放入,否则则放入
		String aString = concurrentMap.putIfAbsent("a","111");
		String bString = concurrentMap.putIfAbsent("a","222");// 不存在时才放入
		System.out.println(aString);// null
		System.out.println(bString);// 111
		
		concurrentMap.remove("a","2121");
		concurrentMap.putIfAbsent("b","333");
		System.out.println(concurrentMap);
		
		concurrentMap.replace("a","1211","4444");// 旧值等于时替换
		concurrentMap.replace("a", "555");// 不比较旧值
		System.out.println(concurrentMap);
		 
 	}
}
