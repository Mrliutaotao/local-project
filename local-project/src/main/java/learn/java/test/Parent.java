package learn.java.test;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月11日下午11:14:33
 * @desc:
 */
public class Parent {

	String parent = "parent";
	
	static String staticParent = "staticParent";
	
	static{
		// System.out.println(parent); 编译错误
		System.out.println("static in parent " + staticParent);
	}
	
	public Parent(){
		System.out.println("construct " + parent);
		System.out.println("construct in parent");
	}
	
	{
		System.out.println("none static " + parent);
		System.out.println("none static in parent");
	}
}
