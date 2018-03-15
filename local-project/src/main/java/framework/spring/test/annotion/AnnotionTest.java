package framework.spring.test.annotion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotionTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotion.xml");
		//AnnotionService annotionService = (AnnotionService) applicationContext.getBean("annotionService");
		AnnotionService annotionService = (AnnotionService) applicationContext.getBean("annotionService");
		AnnotionService annotionServices = (AnnotionService) applicationContext.getBean(AnnotionService.class);
		if(annotionService == annotionServices){
			System.out.println("dafas");
		}
		int add = annotionService.multTowInt(3, 3);
		System.out.println(add);
	}

}
