package framework.spring.test;

public abstract class SpringLookupBean {
	
	public void showMe() {
		this.getBean().showMe();
	}

	public abstract User getBean();
}
