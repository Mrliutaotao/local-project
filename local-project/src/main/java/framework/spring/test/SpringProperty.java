package framework.spring.test;

import java.util.ArrayList;
import java.util.HashMap;

public class SpringProperty {
	
	Integer aInt = 1;
	
	ArrayList<String> aList = new ArrayList<String>();
	
	HashMap<String,String> aMap = new HashMap<String,String>();

	public Integer getaInt() {
		return aInt;
	}

	public void setaInt(Integer aInt) {
		this.aInt = aInt;
	}

	public ArrayList<String> getaList() {
		return aList;
	}

	public void setaList(ArrayList<String> aList) {
		this.aList = aList;
	}

	public HashMap<String, String> getaMap() {
		return aMap;
	}

	public void setaMap(HashMap<String, String> aMap) {
		this.aMap = aMap;
	}
	
	
}
