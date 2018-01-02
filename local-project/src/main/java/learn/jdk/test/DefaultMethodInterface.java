package learn.jdk.test;
/**
*
* @author: liutaotao
* @date  : 2017年12月14日下午7:16:15
*
*/
public interface DefaultMethodInterface {
	
	void getString();
	
	default void printHello(){
		System.out.println("hello");
	}

}
