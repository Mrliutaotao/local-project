package learn.file.test;

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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("outOrderId", "1");
		jsonObject.put("status", "2");
		String msgBody = jsonObject.toJSONString();
		JSONObject object = JSONObject.parseObject(msgBody);
		String string = object.getString("outOrderId");
		System.out.println(string);
		System.out.println(object);
	}
}
