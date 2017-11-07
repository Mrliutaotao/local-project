/*
 * 文 件 名:  RongClient.java
 * 修 改 人:  chenchong@rong360.com
 * 修改时间:  2016年2月25日
 * 修改内容:  <修改内容>
 */
package learn.httpSender.test;

import java.util.Map;

/**
 * 
 * @author  chenchong@rong360.com
 * @date  [2016年3月29日]
 */
public interface RongClient {
    
    public String execute(Map<String,String> params) throws Exception;
    
}
