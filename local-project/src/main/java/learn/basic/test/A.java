package learn.basic.test;
/**
*
* @author: liutaotao
* @date  : 2017年11月8日下午8:12:09
*
*/
public class A {
	
	String aString = "a";
	
	static String staticStringA = "staticA";
	
	static{
		System.out.println(staticStringA);
		System.out.println("static in a ");
	}
	
	public A(){
		System.out.println("in a class");
	}
}
