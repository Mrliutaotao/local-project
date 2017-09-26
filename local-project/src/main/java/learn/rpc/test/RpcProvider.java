package learn.rpc.test;
/**
*
* @author: liutaotao
* @date  : 2017年8月21日上午10:45:47
*
*/
public class RpcProvider {
	public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();  
        RpcFramework.export(service, 1234);  
    } 
}
