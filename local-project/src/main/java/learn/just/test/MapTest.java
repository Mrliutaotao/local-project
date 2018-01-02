package learn.just.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

  


/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月30日下午3:48:15
 * @desc:
 */
public class MapTest {
	public static void main(String [] arg){
		Map map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("c", "c");
		map.put("d", "d");
		map.put("b", "b");
		System.out.println(map);//{null=a}
		Map map2 = new HashMap<String, String>();
		map2.put(new String("a"), "a");
		System.out.println(map.equals(map2));
		
		
		Hashtable table = new Hashtable<String, String>();
		// table.put(null, "a"); // error NPE
		// table.put("a", null); // error NPE
		System.out.println(table);
		
		IdentityHashMap identityHashMap = new IdentityHashMap<String, String>();
		identityHashMap.put("a", "a");
		IdentityHashMap identityHashMap2 = new IdentityHashMap<String, String>();
 		identityHashMap2.put(new String("a"), "a");
		System.out.println(identityHashMap.equals(identityHashMap2));
		
		LinkedHashMap linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("a", "sfda");
		linkedHashMap.put("c", "da");
		linkedHashMap.put("b", "da");
		System.out.println(linkedHashMap);
		
		TreeMap treeMap = new TreeMap<String, String>();
		
		WeakHashMap weakHashMap = new WeakHashMap<String, String>();
	}
}
