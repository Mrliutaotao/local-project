package learn.basic.test;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.*;
import sun.misc.ProxyGenerator;  

/**
 *
 * @author: liutaotao
 * @date : 2017年12月26日下午4:00:13
 *
 */
public class ProxyTest {
	public static void main(String args[]) {
		RealSubject real = new RealSubject();
		Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[] { Subject.class }, new ProxyHandler(real));
		proxySubject.doSomething();

		// write proxySubject class binary data to file
		createProxyClassFile();
	}

	public static void createProxyClassFile() {
		String name = "ProxySubject";
		byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
		try {
			FileOutputStream out = new FileOutputStream(new File("G:\\ProxySubject.class"));
			out.write(data);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
