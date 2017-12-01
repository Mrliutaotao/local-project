package learn.basic.test;
/**
*
* @author: liutaotao
* @date  : 2017年12月1日下午5:54:27
*
*/
public class ObjectTest {
	public static void main(String [] args){
		Object object = new Object();
		// getClass().getName() + '@' + Integer.toHexString(hashCode()) 
		// Object.toString:java.lang.Object@15db9742  
		System.out.println("Object.toString:" + object.toString());
	}
}
