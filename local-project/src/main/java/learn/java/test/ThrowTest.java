package learn.java.test;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月15日下午11:18:08
 * @desc:
 */
public class ThrowTest {
	
	static Integer x ;
	public int inc(){
		try {
			x = 1;
			throw new Exception();
			// return x;
 		} catch (Exception e) {
			x = 2;
			return x;
		}finally {
			x = 3;
		}
	}
	
	public static void main(String[] arg){
		int a = new ThrowTest().inc();
		System.out.println(a);
	}
}
