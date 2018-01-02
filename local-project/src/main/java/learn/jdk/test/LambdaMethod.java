package learn.jdk.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
*
* @author: liutaotao
* @date  : 2017年12月14日下午7:32:53
*
*/
public class LambdaMethod {
	
	
	public static void main(String [] args){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		// 匿名内部类
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		System.out.println(names);
		// Lamada表达式
		List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names2, (String a, String b) -> {
		    return b.compareTo(a);
		});
		Collections.sort(names2, (String a, String b) -> b.compareTo(a));
		Collections.sort(names2, (a, b) -> b.compareTo(a));
		System.out.println(names2);
		
		/**
		 * Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，
		 * 通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda
		 * 表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
		 * 我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，
		 * 你只需要给你的接口添加 @FunctionalInterface 注解，编译器如果发现你标注了这个注解的接口有
		 * 多于一个抽象方法的时候会报错的。
		 */
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		/**
		 * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
		 */
		Converter<String, Integer> converter1 = Integer::valueOf;
		Integer converted1 = converter.convert("123");
		System.out.println(converted1);   // 123
	}
}
