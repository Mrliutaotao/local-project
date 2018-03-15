package framework.spring.test.annotion;

import org.springframework.stereotype.Service;

@Service(value="ser")
public class AutowireService {
	
	private AutowireService(){
		super();
	}
	
	public int multTwoInt(int a,int b){
		return a*b;
	}
}
