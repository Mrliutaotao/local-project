package framework.spring.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class SpringAopTest {
	
public static void main(String [] args) throws InterruptedException, ClassNotFoundException{
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
		SpringAOPBean springAOPBean = (SpringAOPBean) applicationContext.getBean("springAOPBean");
		// 不会触发aop
		springAOPBean.test(); 
		springAOPBean.testAop();
 	}
}
