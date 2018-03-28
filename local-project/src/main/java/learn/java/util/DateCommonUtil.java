package learn.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



/**
* 时间工具类
* @author: liutaotao
* @date  : 2018年2月8日下午12:58:03
*
*/
public class DateCommonUtil {

	public static void main(String[] args) {
		
		String money = "20302.12";
		double fa = Double.parseDouble(money);
		fa = fa * 1000;
		System.out.println(fa);
		Long mones = Math.round(fa);
		System.out.println(mones);
 		
		long adfa = Long.parseLong("2.2");
		System.out.println(adfa);
		
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
		Date repayDate = null;
		try {
			repayDate = simpleDateFormat.parse("2018-03-19");
		} catch (ParseException e) {
				e.printStackTrace();
		}
		
		System.out.println(repayDate);
		
		String[] params = {"1","2","3"};
		List<String> paList = Arrays.asList(params);
		List<String> pdfaList = new ArrayList<String>();
		pdfaList.add("1");
		pdfaList.add("2");
		pdfaList.add("3");
		System.out.println(paList);
		System.out.println(pdfaList);
		
		String aString = "08:00:00";
		String sdsf = aString.substring(0,2);
		System.out.println(sdsf);
		int a = Integer.parseInt(sdsf);
		System.out.println(a);
		
		DateCommonUtil dateCommonUtil = new DateCommonUtil();
		Date now = dateCommonUtil.getDateByModify();
		System.out.println(now);
		
		Date seDate = dateCommonUtil.getSendBatchMessageTime();
		System.out.println(seDate);

	}
	
	public Date getDateByModify(){
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(now);
		dateString = dateString + " 08:00:00";
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
 			e.printStackTrace();
		}
		return null;
	}
	private Date getSendBatchMessageTime(){
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatWithHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDateStr = formatter.format(now);
		String sendTimeStr = "";
		String daString =  "16:00:00";
		sendTimeStr = nowDateStr + " " + daString;
		int hour =  Integer.parseInt(daString.substring(0,2));
		try {
			Date sendTime = formatWithHour.parse(sendTimeStr);
			while( now.getTime() > sendTime.getTime()){
				hour = hour + 1;
				if(hour < 10){
					sendTimeStr = nowDateStr + " 0" + hour + ":00:00";
				}else{
					sendTimeStr = nowDateStr + " " + hour + ":00:00";
				}
				sendTime = formatWithHour.parse(sendTimeStr);
			}
			return sendTime;
		} catch (ParseException e) {
 		}
		return new Date();
	}
}
