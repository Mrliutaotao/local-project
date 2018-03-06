package learn.collection.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
*
* @author: liutaotao
* @date  : 2017骞�12鏈�28鏃ヤ笅鍗�2:27:12
*
*/
public class ArraysTest {
	
	public static void main(String[] args){
		Integer [] array = {1,2,3};
		System.out.println(array.getClass().getName());
		System.out.println(array.length);
		List<Integer> intList = Arrays.asList(array);
		System.out.println(intList.getClass());
		intList.set(0, 0);
		System.out.println(intList.size());
		System.out.println(intList);
		System.out.println(array);
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.iterator();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(3);
		// Collections.sort(arrayList);
		Iterator<Integer> iterator = arrayList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(arrayList.get(1).compareTo(arrayList.get(2)));
		Collections.sort(arrayList, new Comparator<Integer>() {
			public int compare(Integer int1,Integer int2) {
				return int1.compareTo(int2);
			}
		});
		List<Integer> list = Collections.synchronizedList(arrayList);
		System.out.println(arrayList);
		
		Comparator comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
 				return o1.compareTo(o2);
			}
		};
		
	}
}
