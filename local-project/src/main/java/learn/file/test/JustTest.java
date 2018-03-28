package learn.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Locale.FilteringMode;

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
	public static void main(String[] args) throws ParseException, IOException{
		
		File oldFile = new File("C:\\Users\\AC\\Desktop\\resource.txt");
		if (!oldFile.exists() ) {
			throw new FileNotFoundException();
		}
		File newfile = new File("C:\\Users\\AC\\Desktop\\destine.txt");
        if(!newfile.exists()){
        	newfile.createNewFile();
        }
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile)));

		//  FileOutputStream out=new FileOutputStream(newfile,true);
		BufferedReader br = new BufferedReader(new FileReader(oldFile));
		String temp = null;
		// StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			temp = "'" + temp + "',";
			// temp = temp + ",";
			// out.write(temp.getBytes("utf-8"));
			out.write(temp.toCharArray());
			out.newLine();
			out.flush();
			temp = br.readLine();
		}
        out.close();
        br.close();
		        
		
		Map<String,String> mqBosdyMap = new HashMap<String,String>();
		mqBosdyMap.put("date","2017-11-28");
		Object aJsonObject =  JSON.toJSON(mqBosdyMap);
		System.out.println(aJsonObject);
		
		Long amtPay = 12430L;
		String money = new BigDecimal(Double.toString(amtPay.doubleValue() / 1000)).setScale(4, BigDecimal.ROUND_HALF_UP).toString();

 
		System.out.println(money);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2017-11-11");
		String endTimeStr = sdf.format(date);
		String endTime = endTimeStr + " 23:59:59";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int  endDate = Integer.parseInt(date.getTime() / 1000 + "");
		 
		System.out.println(endDate);
		
		ClassLoader classLoader ;
		
 		
		String lll = null;
		String fafd = lll + "";
		System.out.println(fafd);
		
		int dafa = 0;
		dafa ++;
		
		Map<String,String> mqBodyMap = new HashMap<String,String>();
		mqBodyMap.put("userId",12700723+"");			
		String msgsBody = JSON.toJSONString(mqBodyMap);
		System.out.println(msgsBody);
		 JSONObject jsonOsbject = JSON.parseObject(msgsBody);
         Map<String, String> map = (Map) jsonOsbject;
         Long userIds = Long.parseLong(map.get("userId"));
 		System.out.println(userIds);

         
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
