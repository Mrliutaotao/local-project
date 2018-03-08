package framework.spring.test;

public class CircleBeanA {

	CircleBeanB  circleBeanB;
	
	public CircleBeanA(CircleBeanB circleBeanB){
		this.circleBeanB = circleBeanB;
	}

	public CircleBeanB getCircleBeanB() {
		return circleBeanB;
	}

	public void setCircleBeanB(CircleBeanB circleBeanB) {
		this.circleBeanB = circleBeanB;
	}
	
	public void saySomthing(){
		this.circleBeanB.sayHello();
	}

	public void sayHello() {
		System.out.println("circleA hello");
		
	}
}
