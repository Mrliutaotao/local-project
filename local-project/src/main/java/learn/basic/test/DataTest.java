package learn.basic.test;
/**
*
* @author: liutaotao
* @date  : 2017年11月18日下午8:21:15
*
*/
public class DataTest {

    public static void main(String[] args) {  
    	  
        float f_v1 = 20;    
        float f_v2 = 20.3f;    
        float f_v3 = 20.5f;    
                
        double d_v1 = 20;    
        double d_v2 = 20.3;    
        double d_v3 = 20.5;  
          
        System.out.println((f_v1 == d_v1)?"true":"false");   // true
        System.out.println(f_v2 == d_v2?"true":"false");     // false
        System.out.println(f_v3 == d_v3?"true":"false");     // true
          
    }  
}
