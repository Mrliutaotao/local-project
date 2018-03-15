package framework.spring.test.annotion;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value="annotionService" ) // 可以按照类型获取实例,或者按照value获取
@Scope("singleton")
// @Scope("prototype")
// @Service   // 可以按照类型获取实例,或者按照首字母小写获取实例,例如获取annotionService实例
public class AnnotionService {

	/*@Autowired(required=false)
	@Qualifier("autowireService")     
	private AutowireService autowireService;*/
	
	@SuppressWarnings("restriction")
	// @Resource  // 默认按照名称匹配,匹配不到再按照类型匹配
	@Resource(name="ser") // 按照名称匹配
	private AutowireService autowireService;
	
	
	public int addTowInt(int a,int b){
		return a + b;
	}
	
	public int multTowInt(int a,int b) {
		return autowireService.multTwoInt(a, b);
	}
	
}
