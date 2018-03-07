package framework.spring.test;

public class SpringMetaBean {
	
	String testStr = "testStr";
	
	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public String getTestStr(){
		System.out.println(testStr);
		return testStr;
	}
}
