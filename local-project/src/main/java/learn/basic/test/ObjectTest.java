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
		InterfaceTest interfaceTest = new ImplementTest();
		Class<? extends Object> interfaceClass = interfaceTest.getClass();
		System.out.println(interfaceClass);
		Class<? extends Object> objectClass = object.getClass();
		System.out.println(objectClass);
		// getClass().getName() + '@' + Integer.toHexString(hashCode()) 
		// Object.toString:java.lang.Object@15db9742  
		System.out.println("Object.toString:" + object.toString());
	}
}
