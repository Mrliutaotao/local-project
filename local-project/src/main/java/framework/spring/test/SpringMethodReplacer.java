package framework.spring.test;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class SpringMethodReplacer implements MethodReplacer{

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("替换原有方法");
		return null;
	}

}
