package learn.httpSender.test;

import learn.httpSender.test.ClientManager;
import learn.httpSender.test.RongClient;
 
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author guocong
 *         Created by Administrator on 2016/3/31.
 */
public class RequestUtil {
    public static String request(String method, Map<String, Object> bizData) throws Exception {
        Map<String, String> params = new HashMap<String,String>();
        params.put("method", method);
        params.put("biz_data", JSONObject.parseObject(bizData.toString()).toString());

        RongClient client = ClientManager.createClient();
        return client.execute(params);
    }
}
