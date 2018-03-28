package learn.proxy.test.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibProxy2 implements MethodInterceptor {
	 
	private String name;

	public MyCglibProxy2(String name) {
		this.name = name;
	}
	
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
 		// 用户进行判断
		if (!"boss".equals(name)) {
			System.out.println("你没有权限！");
			return null;
		}
		Object result = methodProxy.invokeSuper(object, args);

		return result;
	}
}
