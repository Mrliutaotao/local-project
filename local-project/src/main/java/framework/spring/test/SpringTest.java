package framework.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*
* @author: liutaotao
* @date  : 2018年1月22日下午2:41:59
*
*/
public class SpringTest {
	
	private static ClassPathXmlApplicationContext context;
	
	public static void main(String [] args) throws InterruptedException{
		 
		String[] configs = {"spring.xml"};
		context = new ClassPathXmlApplicationContext(configs);
		context.start();
		Thread.sleep(1000L);
		BeanFactory beanFactory = context.getBeanFactory();
		SpringBeanTest beanTest = (SpringBeanTest) beanFactory.getBean("springBeanTest");
		beanTest.print("bean hello");
 	}
}
