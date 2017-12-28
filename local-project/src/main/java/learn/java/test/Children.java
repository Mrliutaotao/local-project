package learn.java.test;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月11日下午11:18:44
 * @desc:
 */
public class Children extends Parent{
	
	String children = "children";
	
	static String staticChildren = "staticChildren";
	
	static{
		// System.out.println(children); 编译错误
		System.out.println("static in children " + staticChildren);
	}
	
	{
 		System.out.println("none static in children");
	}
	
	public Children(){
		super();
 		System.out.println("construct in children");
	}
}
