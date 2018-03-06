package framework.spring.test;

import org.springframework.stereotype.Service;

@Service
public class SpringBean {
	
	public void print(String words){
		System.out.println(words);
	}
	
	public void init(){
		System.out.println("init");
	}
}
