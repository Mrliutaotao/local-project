package learn.basic.test;
/**
*
* @author: liutaotao
* @date  : 2017年12月22日下午4:08:26
*
*/
public class ExceptionTests {
	
	public static void main(String [] args){
		int a = new ExceptionTests().exceptionThrow();
		System.out.println(a);
	}
	
	public int exceptionThrow(){
		int a = 1;
		try {
			a = 2;
			throw new Exception();
			// return a;
		} catch (Exception e) {
			a = 3;
		}finally {
			a = 4;
		}
		return a;
	}
}
