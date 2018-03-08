package framework.spring.test;

public class BeanA {

	BeanB beanB;

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}
	
	public void saySomething(){
		this.beanB.sayHello();
	}
	
}
