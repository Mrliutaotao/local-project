package learn.basic.test;

/**
 *
 * @author: liutaotao
 * @date : 2017年12月18日下午8:16:29
 *
 */
public class StaticTest {

	public static void main(String[] args) {
		staticFunction();
		// 调用静态方法,首先会触犯类初始化,静态变量初始化,new StaticTest();
		// 实例初始化 2,静态初始化,构造初始化3, a=
		// new StaticTest() 2, 3 , a=0,b=112
		/*
		 * 2
3
a=110,b=0
1
4

		 */
	}

	static StaticTest st = new StaticTest();

	static {
		System.out.println("1");
	}

	{
 		System.out.println("2");
	}

	StaticTest() {
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	}

	public static void staticFunction() {
		System.out.println("4");
	}

	int a = 110;
	static int b = 112;
}
