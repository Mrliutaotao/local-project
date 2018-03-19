package learn.proxy.test.jdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sun.misc.ProxyGenerator;


public class UserProxy {
	
	public static void main(String[] args) {
		// System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
		UserService userService = new UserServiceImpl();
		UserServiceHandler handler = new UserServiceHandler(userService);
		Person userServiceProxy  = (Person)handler.getProxy();
		//UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);
		// userServiceProxy.removeUser();
		userServiceProxy.speak("   lala  ");
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
