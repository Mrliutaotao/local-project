package learn.thread.sync;

import java.io.IOException;

/**
*
* @author: liutaotao
* @date  : 2018年1月10日下午2:17:26
*
*/
public class InterruptTest {
	public static void main(String[] args) throws IOException  {
		Mythread thread = new Mythread();
        thread.start();
        /* try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
             
        } */
        System.out.println("中断前");
        thread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println("中断后");
     } 
     
    
}
class Mythread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("进入睡眠状态");
            int j = 1;
            for(int i = 0; i < 1000000 ; i ++){
            	j ++;
            }
           // Thread.currentThread().yield();
           // Thread.currentThread().sleep(10000);
            System.out.println("睡眠完毕");
        } catch (Exception e) {
            System.out.println("得到中断异常");
        }
        System.out.println("run方法执行完毕");
    }
}