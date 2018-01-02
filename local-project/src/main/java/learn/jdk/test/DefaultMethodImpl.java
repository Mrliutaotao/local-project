package learn.jdk.test;
/**
*
* @author: liutaotao
* @date  : 2017年12月14日下午7:22:50
*
*/
public class DefaultMethodImpl implements DefaultMethodInterface{

	 
	public void getString() {
		System.out.println("get String");
	}
	
	/*@Override
	public void printHello(){
		System.out.println("dafd");
	}*/
	
	public static void main(String [] args){
		DefaultMethodInterface impl = new DefaultMethodImpl();
		impl.printHello();
	}
}
