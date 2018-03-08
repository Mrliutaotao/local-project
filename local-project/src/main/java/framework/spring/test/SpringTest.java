package framework.spring.test;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
*
* @author: liutaotao
* @date  : 2018年1月22日下午2:41:59
*
*/
public class SpringTest {
	
	private static ClassPathXmlApplicationContext context;
	
	public static void main(String [] args) throws InterruptedException, ClassNotFoundException{
		
		BeanFactory bFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		boolean isSigleton = bFactory.isSingleton("springBean");
		System.out.println(isSigleton);
		
		
		SpringBean beanFTest = (SpringBean) bFactory.getBean("springBean");
		beanFTest.print("bean factory hello");
 		
		// meta Test
		SpringMetaBean springMetaBean = (SpringMetaBean) bFactory.getBean("springMetaBean");
		System.out.println(springMetaBean.getTestStr());
		 
		
		// lookup Test
		SpringLookupBean springLookupBean = (SpringLookupBean) bFactory.getBean("springLookupBean");
		springLookupBean.showMe();
		
		//replaced-method Test
		ChangeMethod changeMethod = (ChangeMethod) bFactory.getBean("changeMethod");
		changeMethod.changeMe();
		
		// contructor
		SpringConstructor springConstructor = (SpringConstructor) bFactory.getBean("springConstructor");
		springConstructor.sayHello();
		
		// property
		SpringProperty springProperty = (SpringProperty) bFactory.getBean("springProperty");
		System.out.println(springProperty.getaInt());
		System.out.println(springProperty.getaList());
		System.out.println(springProperty.getaMap());
		
		String[] configs = {"spring.xml"};
		context = new ClassPathXmlApplicationContext(configs);
		context.start();
		Thread.sleep(1000L);
		BeanFactory beanFactory = context.getBeanFactory();
		SpringBean beanTest = (SpringBean) beanFactory.getBean("springBean");
		beanTest.print("bean hello");
 	}
}
