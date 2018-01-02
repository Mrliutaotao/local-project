package learn.jdk.test;
/**
*
* @author: liutaotao
* @date  : 2017年12月14日下午8:23:47
*
*/
@FunctionalInterface
interface Converter<F, T> {
	    T convert(F from);
}
