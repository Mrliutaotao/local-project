package learn.proxy.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceHandler implements InvocationHandler{
	
	private Object target;
	
	public UserServiceHandler(Object target) {
		this.target = target;
	}
	
	private void before(){
		System.out.println("before method");
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		method.invoke(target, args);	
		return null;
	}

	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
	}
}
