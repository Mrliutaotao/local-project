package learn.rpc.test;
/**
*
* @author: liutaotao
* @date  : 2017年8月21日上午10:46:44
*
*/
public class RpcConsumer {
	public static void main(String[] args) throws Exception {  
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);  
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {  
            String hello = service.hello("World" + i);  
            System.out.println(hello);  
            Thread.sleep(1000);  
        }  
    }  
}
