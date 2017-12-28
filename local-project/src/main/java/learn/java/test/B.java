package learn.java.test;
/**
*
* @author: liutaotao
* @date  : 2017年11月8日下午8:13:32
*
*/
public class B extends A{
	
	String aString = "b";
	
	static String staticString = "staticB";
	
	static{
		System.out.println(staticString);
		System.out.println("static in b ");
	}
	
	public B(){
		System.out.println("in b class");
	}
}
