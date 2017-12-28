package learn.file.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

 

/**
*
* @author: liutaotao
* @date  : 2017年11月7日下午9:11:15
*
*/
public class JustTest {
	public static void main(String[] args){
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.add(10);
		result.add(11);
		result.add(9);
		if (result.size() > 0) {
			Collections.sort(result, new Comparator<Integer>() {
				public int compare(Integer arg0, Integer arg1) {
					return arg0 - arg1;
				}
			});
		}
		System.out.println(result);
		
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for(String item : list){
			if("2".equals(item)){
				list.remove(item);
			}
		}
		System.out.println(list);
		
		HashMap<String,String> aHashMap = new HashMap<String, String>();
		
		aHashMap.put("1", "a");
		aHashMap.put("1","b");
		System.out.println(aHashMap);
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("order_id", null);
		String msgBody = jsonObject.toJSONString();
		System.out.println(msgBody);

		JSONObject object = JSONObject.parseObject(msgBody);
		String string = object.getString("outOrderId");
		Date s = object.getDate("modifyTime");

		System.out.println(s);
		System.out.println(object);
		
	}
}
