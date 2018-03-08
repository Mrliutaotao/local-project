package framework.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringGetBeanTest {

	public static void main(String[] args) {
		// 构造器依赖无法解决
		BeanFactory bFactory = new XmlBeanFactory(new ClassPathResource("spring2.xml"));
		/*CircleBeanA circleBeanA = (CircleBeanA) bFactory.getBean("circleBeanA");
		circleBeanA.saySomthing(); */
		
		BeanA beanA = (BeanA) bFactory.getBean("beanA");
		beanA.saySomething();

	}

}
