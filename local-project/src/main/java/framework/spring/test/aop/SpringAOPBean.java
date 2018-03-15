package framework.spring.test.aop;

public class SpringAOPBean {
	
	private String testStr = "aop test";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	
	public void testAop(){
		System.out.println(testStr);
	}
	
	public void test(){
		this.testAop();
	}
}
