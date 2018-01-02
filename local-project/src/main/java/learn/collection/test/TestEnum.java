package learn.collection.test;

/**
 *
 * @author: liutaotao
 * @date : 2017年12月29日下午5:37:13
 *
 */
public enum TestEnum {
	
	QDH("QDH", "取点花"), 
	BYJ("BYJ", "毕业金"),
	QCP("QCP", "短期产品"),
	PFQ("PFQ", "商品分期"), 
	DFQ("DFQ", "账单分期"), 
	QKF("QKF","信用商品");

	private String value;
	private String text;

	private TestEnum(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
