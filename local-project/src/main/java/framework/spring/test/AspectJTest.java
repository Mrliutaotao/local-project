package framework.spring.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJTest {
	
	@Pointcut("execution(* *.testAop(..))")
	public void test(){
		
	}
	
	@Before("test()")
	public void beforeTest(){
		System.out.println("before test");
	}
		
	@After("test()")
	public void afterTest(){
		System.out.println("after test");
	}
	
	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p) {
		System.out.println(" around before");
		Object object = null;
		try {
			object = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(" around after");
		return object;
	}
}
