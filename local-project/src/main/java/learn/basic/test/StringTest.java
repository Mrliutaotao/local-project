package learn.basic.test;
/**
*
* @author: liutaotao
* @date  : 2017年11月8日下午8:26:14
*
*/
public class StringTest {
	
	public static void main(String [] args){
		String string1 = "da";
		String string2 = "da";
		String string3 = new String("da");
		// 使用字面量初始化时,当字面量相同时不会新建对象
		System.out.println(string1 == string2);// true
		System.out.println(string2 == string3);// true
		String string4 = "ab";
		String string5 = "中国";
		// String存储的是已char字符为单位的,一个汉字与一个字母都是一个字符
		System.out.println(string4.length());
		System.out.println(string5.length());
		String string6 = "abc";
		// 返回第n个字符,从0开始
		System.out.println(string6.charAt(1));// b
		String string7 = "abc";
		char [] strChar = new char[2];
		// getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
		// 将string字符数组复制入dst[]数组,复制字符srcBegin<= x < srcEnd放入dst起始为dstBegin中
		string7.getChars(1, 2, strChar, 1);
		System.out.println(strChar[1]);// b
		String string8 = "a";
		byte[] strByte1 = string8.getBytes();
		for(byte by : strByte1){
			System.out.println(by);// 97,a的unicode编码为97
		}
		String string9 = "中";
		byte[] strByte2 = string9.getBytes();
		for(byte by : strByte2){
			// 中文采用三字节编码,将unicode转换成utf-8存储
			System.out.println(Integer.toBinaryString(by));// 中的unicode编码'\u4e2d'
		}
		String string10 = "中国";
		char [] chArray = string10.toCharArray();
		System.out.println(chArray.length);//2
		System.out.println(chArray[1]);// 国
		String string11 = "abc";
		String string12 = new String("abc");
		String string13 = "Abc";
		// String复写了equals方法比较的是内容是否一致,字符是否一致
		System.out.println(string11.equals(string12));// ture
		// 先比较是否相等,如果不相等则比较都转化成大写是否相等
		System.out.println(string12.equalsIgnoreCase(string13));// true
		String string14 = "aa";
		String string15 = "ca";
		// 比较第一个不相同的字符的差值
		System.out.println(string14.compareTo(string15));// -2
		String sring16 = "abcd";
		System.out.println(sring16.contains("bc"));// true
		String sring17 = "abc";
		System.out.println(sring17.startsWith("abc"));// true
		System.out.println(sring17.endsWith("bc"));// true
		String string18 = "abc";
		// indexOf(String s) 返回s在字符串中第一出现的位置,没有出现返回-1
		System.out.println(string18.indexOf("a"));// 0
		System.out.println(string18.indexOf("ab"));// 0
		System.out.println(string18.indexOf("ac"));// -1
		// indexOf(int ch) 返回unicode ch所代表的字符在原串中出现的位置 ,没有返回-1
		System.out.println(string18.indexOf(99));// 2 c的unicode99
		// indexOf(int ch,int index) 返回unicode ch所代表的字符在原串中index之后出现的位置 ,没有返回-1
		System.out.println(string18.indexOf(97,0));// 0
		System.out.println(string18.indexOf(97,1));// -1
		String string19 = "abcabcabc";// 0 - 8
		// lastIndexOf(int ch,int index) 从index开始,对于<=index的字符,倒过来第一个匹配的位置
 		System.out.println(string19.lastIndexOf(97,8));// 6 abcabcabc abcabc a bc
 		System.out.println(string19.lastIndexOf(97,4));// 3 abcab abc a b
 		System.out.println(string19.lastIndexOf(97,1));// 0 ab a b
 		String string20 = "abcd";
 		// subString(int beginIndex,endIndex) beginIndes<= x < endIndex
 		System.out.println(string20.substring(0, 2));// ab
 		System.out.println(string20);// abcd,不影响原值
 		String string21 = "abcd";
 		String string22 = string21.concat("efg");
 		System.out.println(string22);// abcdefg 
 		String string23 = "abcabc";
 		String string24 = string23.replace('a', 'g');
 		String string25 = string23.replace('h', 'g');
 		// 替换字符串中的字符,若有替换则新建字符串若无替换返回原值
 		System.out.println(string23);// abcabc
 		System.out.println(string24);// gbcgbc
 		System.out.println(string25);// abcabc
 		String string26 = "abcDEF";
 		String string27 = string26.toLowerCase();
 		String string28 = string26.toUpperCase();
 		// 改变字符大小,若有改变则新建字符串若无改变返回原值
 		System.out.println(string27);// abcdef
 		System.out.println(string28);// ABCDEF
 		String string29 = " a bc  ";
 		String string30 = string29.trim();
 		// 删除两边的空格,若有改变则新建,否则返回原值
 		System.out.println(string30);// a bc
 		String string31 = "abc";
 		// 生成静态池常
 		string31.intern();

 		System.out.println(String.valueOf(false));// false
 		System.out.println(String.valueOf('a'));// a
 		
		/*
		 11111111111111111111111111100100  11100100 
		 11111111111111111111111110111000  10111000
		 11111111111111111111111110101101  10101101 
		中 '\u4e2d'
		0100 1110 0010 1101  
		U+ 0800 ~ U+ FFFF: 1110XXXX 10XXXXXX 10XXXXXX
		    0100   111000   101101  
 		1110XXXX 10XXXXXX 10XXXXXX
		11100100 10111000 10101101
		*/
	}
}
