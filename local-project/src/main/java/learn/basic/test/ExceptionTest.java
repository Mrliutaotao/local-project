package learn.basic.test;

import java.io.IOException;

/**
*
* @author: liutaotao
* @date  : 2017年12月21日下午9:53:34
*
*/
public class ExceptionTest {
	
	class NumberInt{
		public NumberInt(int a){
			this.a = a;
		}
		Integer a = 0;
	}
	
	public static void main(String [] strings) throws Exception{
		NumberInt a = new ExceptionTest().exceptionTest();
		System.out.println(a.a);
	}
	
	public NumberInt exceptionTest() throws Exception{
		NumberInt numberInt = new NumberInt(1);
		// Integer a = 1;
		try {
			numberInt = new NumberInt(2);
			//return numberInt;
			// a = 2/0;
			throw new Exception("");
		} catch (Exception e) {
			numberInt = new NumberInt(3); 
			//return a;
			// throw new Exception("");
  		}finally {
  			numberInt.a = 4;
			// return a ;
		}
		// System.out.println(a);
		return numberInt;
	}
}
