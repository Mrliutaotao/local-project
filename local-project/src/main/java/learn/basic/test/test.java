package learn.basic.test;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author: liutaotao
* @date  : 2017年11月27日下午7:21:19
*
*/
public class test {
	static int a = 1;
	
	public static void main(String[] args) {
		List<String> dafd = new ArrayList<>();
		List<String> ad = null;
		dafd.addAll(ad);
		
		int a = -1;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a>>>2);
		System.out.println(Integer.toBinaryString(a>>>2));
		int b = -1;
		System.out.println(Integer.toBinaryString(b));
		System.out.println(b>>2);
		System.out.println(Integer.toBinaryString(b>>2));
		int c = 4;
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(c>>2));
		int d = 1;
		System.out.println(d++);
		int f = 1;
		System.out.println(++f);
				
	}

}
