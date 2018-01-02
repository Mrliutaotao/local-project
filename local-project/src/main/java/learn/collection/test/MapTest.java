package learn.collection.test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
*
* @author: liutaotao
* @date  : 2017年12月29日下午4:01:20
*
*/
public class MapTest {
	
	enum Operate{
	    ADD, UPDATE, DELETE; 
	}
	public static void main(String [] arg){ 
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		
		
		
		Map<Operate, String> enumMap = new EnumMap<Operate, String>(Operate.class);
		System.out.println(enumMap.keySet());
		System.out.println(Operate.ADD.ordinal());
		System.out.println(Operate.ADD.getClass());
		enumMap.put(Operate.ADD, "add");
		System.out.println(enumMap);
 		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put(null, "a");
		map.put("2", "b");
		System.out.println(map);
	}
}
