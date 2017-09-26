import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
*
* @author: liutaotao
* @date  : 2017年8月2日下午4:24:58
*
*/
public class JustTest {
	
	public static void main(String [] ar) throws ParseException  {
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
