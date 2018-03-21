package learn.proxy.test.jdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sun.misc.ProxyGenerator;

/**
 * JDK动态代理:
 * 需要被代理的类 UserService userService = new UserService();
 * 代理类 UserProxy userProxy = new UserProxy()
 * 处理类 UserHandler userHandler = new UserHandler()
 * 
 * 被代理的类需要实现接口,处理类需要实现InvocationHandler
 * 代理类根据被代理的类的接口定义,类加载器生成代理类,代理类中实现被代理类的每个方法,在每个方法中去调用实际被
 * 代理的类,并且可以在调用方法前后添加一定的逻辑实现不同的功能
 * 
 * JDK动态代理为啥代理非实现接口类,因为生成的代理类继承了Proxy实现了被代理类的接口,而java是单继承
 *
 */
public class UserProxyTest {
	
	public static void main(String[] args) {
		
		// System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
		UserService userService = new UserServiceImpl();
		UserServiceHandler handler = new UserServiceHandler(userService);
		Person userServiceProxy  = (Person)handler.getProxy();
		//UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
		// userServiceProxy.removeUser();
		userServiceProxy.speak("   lala  ");
		
		PersonProxy personProxy = new PersonProxy(handler);
		personProxy.speak(" person proxy ");

		createProxyClassFile();
		
	}
	
	private static void createProxyClassFile() {
        String name = "PersonProxy";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Person.class });
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
