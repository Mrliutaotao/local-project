package framework.spring.test;

public class CircleBeanB {
	
	CircleBeanA circleBeanA;
	
	public CircleBeanB(CircleBeanA circleBeanA){
		this.circleBeanA = circleBeanA;
	}

	public CircleBeanA getCircleBeanA() {
		return circleBeanA;
	}

	public void setCircleBeanA(CircleBeanA circleBeanA) {
		this.circleBeanA = circleBeanA;
	}

	public void saySomething(){
		circleBeanA.sayHello();
	}
	
	public void sayHello() {
		System.out.println("circleB hello"); 
		
	}

}
