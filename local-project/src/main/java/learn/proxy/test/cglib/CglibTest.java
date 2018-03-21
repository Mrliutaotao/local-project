package learn.proxy.test.cglib;

import java.io.IOException;
import java.io.InputStream;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\learnFile\\code");

        Programmer progammer = new Programmer();
        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理  
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类  
        enhancer.setSuperclass(progammer.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用,都会调用CallBack,而Callback则需要实行intercept()方法进行拦截  
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
    }
}
