package learn.basic.test;

import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import io.netty.util.internal.ObjectUtil;

/**
*
* @author: liutaotao
* @date  : 2017年12月1日下午5:54:27
*
*/
public class ObjectTest {
	public static void main(String [] args) throws InterruptedException{
		MyObject myObject = new MyObject();
		myObject.method();
 		System.out.println("da");
		Object object1 = new Object();
	 
		Thread thread = new Thread(new Runnable() {			
			@Override
			public void run() {
				synchronized (object1) {
					System.out.println("syn 2 start ");
					try {
						Thread.currentThread().sleep(2000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					object1.notifyAll();
					System.out.println("syn 2 end ");
				}
			}
		});
		thread.start();

 		synchronized (object1) {
			System.out.println("syn 1 start ");
			object1.wait();
			System.out.println("syn 1 end ");
		}
		
		/**
		 * syn 1 start 
		 * syn 2 start 
		 * syn 2 end 
		 * syn 1 end
		 * 
		 * 
		 */
		
		
		/*
		Object object = new Object();
		InterfaceTest interfaceTest = new ImplementTest();
		Class<? extends Object> interfaceClass = interfaceTest.getClass();
		System.out.println(interfaceClass);
		Class<? extends Object> objectClass = object.getClass();
		System.out.println(objectClass);
		
		Map<String, String> map = new HashMap<>();
		Class mapClass = map.getClass();
		System.out.println(mapClass);
		Method [] methods =  map.getClass().getMethods();
		for(int i = 0;i< methods.length ;i++){
			  System.out.println(methods[i]);
		}*/
	}
}
class MyObject {
	synchronized void method() throws InterruptedException{
		System.out.println("dadada");
		this.wait();
		System.out.println("dada");
	}
}
