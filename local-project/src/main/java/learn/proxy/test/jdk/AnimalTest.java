package learn.proxy.test.jdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class AnimalTest {

	public static void main(String [] args){
		
		createProxyClassFile();

		Animal animal = new Animal();
		AnimalHandler animalHandler = new AnimalHandler(animal);
		Object object = Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(),animalHandler);
		
		System.out.println(object.getClass().getName());
		Object animalProxy = Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(),animalHandler);
		System.out.println(animalProxy.getClass().getName());
		
	}
	
	private static void createProxyClassFile() {
        String name = "Animal";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Animal.class });
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
