package framework.spring.test;

public class BeanB {
	
	BeanA beanA;

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
	}

	public void sayHello() {
		System.out.println("hello B");
	}
	
}
