package learn.basic.test;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月30日下午10:40:36
 * @desc:
 */
public class OperatorTest {
	public static void main(String[] args) {
		int a = -1;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(a>>>2);
		System.out.println(Integer.toBinaryString(a>>>2));
		int b = -1;
		System.out.println(Integer.toBinaryString(b));
		System.out.println(b>>2);
		System.out.println(Integer.toBinaryString(b>>2));
		int c = 4;
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(c>>2));
		int d = 1;
		System.out.println(d++);
		int f = 1;
		System.out.println(++f);
				
	}
}
