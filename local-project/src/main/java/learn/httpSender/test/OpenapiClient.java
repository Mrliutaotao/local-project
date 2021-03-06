package learn.httpSender.test;
 
import com.alibaba.fastjson.JSONObject;

import learn.httpSender.test.OpenapiRequest;
import learn.httpSender.test.RequestUtil;

public class OpenapiClient
{
    private String  method;
    private OpenapiRequest openapiRequest = new OpenapiRequest();

    public JSONObject execute() throws Exception
    {
        String result = RequestUtil.request(this.method, this.openapiRequest.getParams());
        if (result == null || result.length() == 0) {
            throw new Exception("Request  interface returns null");
        }
        JSONObject jsonRet = JSONObject.parseObject(result);
        if (jsonRet == null) {
            throw new Exception("Request interface got a non-json result");
        }
        return jsonRet;
    }
    public void setMethod(String method)
    {
        this.method= method;
    }
    public void setField(String key, String value)
    {
        this.openapiRequest.putParam(key, value);
    }

    public static void main(String[] args) throws Exception
    {
        OpenapiClient sample= new OpenapiClient();
        sample.setMethod("is.api.v3.order.orderfeedback");
        sample.setField("order_no", "247021091507000");
        sample.setField("order_status", "170");
        JSONObject ret= sample.execute();
        System.out.println(ret.toString());

    }
}
