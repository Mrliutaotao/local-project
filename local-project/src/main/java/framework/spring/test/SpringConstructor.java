package framework.spring.test;

public class SpringConstructor {
	
	private String name = "liu";
	
	private String words = "hello";
	
	public SpringConstructor(String name,String words) {
		 this.name = name;
		 this.words = words;
	}
	
	public void sayHello(){
		System.out.println(words + " " + name);
	}
	
}
