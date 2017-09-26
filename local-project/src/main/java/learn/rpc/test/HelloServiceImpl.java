package learn.rpc.test;
/**
*
* @author: liutaotao
* @date  : 2017年8月21日上午10:44:37
*
*/
public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "Hello" + name;
	}

}
