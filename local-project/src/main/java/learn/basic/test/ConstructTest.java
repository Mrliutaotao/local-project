package learn.basic.test;

/**
* @author: liutaotao
* @date  : 2017年11月8日下午8:09:05
*
*/
/**
 * 构造器Constructor不能被继承，因此不能重写Override，但可以被重载Overload。
 * 
 * Constructor不能被继承，所以Constructor也就不能被override。每一个类必须有自己的构造函数，负责构造自己这部分的构造。子类不会覆盖父类的构造函数，相反必须负责在一开始调用父类的构造函数。
 * 
 * 一、构造器是干什么用的？（what）
 * 
 * 构造器是用来生成一个类的实例是用来初始化这个实例用的
 * 
 * 二、构造器如何工作？（how）
 * 
 * Java在构造实例时的顺序是这样的：
 * 
 * 1、分配对象空间，并将对象中成员初始化为0或者空，java不允许用户操纵一个不定值的对象。
 * 
 * 2、执行属性值的显式初始化
 * 
 * 3、执行构造器
 * 
 * 4 、将变量关联到堆中的对象上 
 * 
 * 而执行构造器的步骤有可以分为以下几步：
 * 
 * 1、Bind构造器的参数
 * 
 * 2、如果显式的调用了this，那就递归调用this构造器然后跳到步骤5
 * 
 * 3、递归调用显式或者隐式的父类构造器，除了Object以外，因为它没有父类
 * 
 * 4、执行显式的实例变量初始化（也就是上边的流程中的第二步，调用返回以后执行，
 * 
 * 这个步骤相当于在父构造器执行后隐含执行的，看样子像一个特殊处理）
 * 
 * 三、构造器不可被orerride（why）

 * 其实你只需要记住一句话：构造器不是方法，那么用来修饰方法特性的所有修饰符都不能用来修饰构造器（并不等与构造器
 * 
 * 具备这些特性，虽然不能用static修饰构造器，但它却有静态特性）构造器只能用 public private protected这
 * 
 * 三个权限修饰符，且不能有返回语句。
 *
 */
public class ConstructTest {

	public static void main(String[] args) {
 
		syso();
 		//Children children2 = new Children();
 	}
	
	static ConstructTest constructTest = new ConstructTest();
	
	static{
		System.out.println("1");
	}
	
	String a = "a";
	static String b = "b";
	
	{
		System.out.println("2");
	}
	
	public ConstructTest() {
		System.out.println("construct init");
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	} 
	
	public static void syso(){
		System.out.println("4");
	}
	

	
	/**
	 * 实例初始化不一定要在类初始化结束之后才开始初始化。
	 * 2
construct init
3
a=a,b=null
1
4
	 */
}
