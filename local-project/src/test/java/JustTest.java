import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;


/**
*
* @author: liutaotao
* @date  : 2017年8月2日下午4:24:58
*
*/
public class JustTest {
	
	public static void main(String [] ar) throws ParseException  {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(new Date());
		testPlan testPlan = new testPlan();
		testPlan.setItem(dateList);
		String ad = JSONObject.toJSONString(testPlan);
    	System.out.println(ad);
		
		JSONObject result = new JSONObject();
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("operate_id", "daf");
    	result.put("plans", "12121");
    	System.out.println(result);
    	String aString = result.toJSONString();
    	String dadf = JSONObject.toJSONString(map);
    	System.out.println(dadf);
    	 
    	SimpleDateFormat formadt = new SimpleDateFormat("yyyy-MM-dd");
		String daf = formadt.format(new Date()); 
		System.out.println(daf);
		
		
		int year = 201708/100;
		int month = Integer.parseInt((201708 + "").substring(4, 6));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date date = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String aDate = format.format(date); 
		Date lDate = format.parse(aDate);
		System.out.println(date);
	}
	
}
