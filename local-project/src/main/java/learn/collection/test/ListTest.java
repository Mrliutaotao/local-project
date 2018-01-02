package learn.collection.test;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author: liutaotao
* @date  : 2017年12月28日下午5:42:46
*
*/
public class ListTest {
	public static void main(String [] arg){
		List<String> a = new ArrayList<String>();
		// a.add(1);
		a.add("1");
		a.add("2");
		System.out.println(a.get(0).getClass());
		System.out.println(a.get(1).getClass());
	}
}
