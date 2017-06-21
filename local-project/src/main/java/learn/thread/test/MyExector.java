package learn.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
*
* @author: liutaotao
* @date  : 2017年6月20日下午2:11:43
*
*/

public class MyExector extends Thread{
	
	int index;
	
	public MyExector(int index) {
		this.index = index;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("[" + this.index + "]  start....");
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("[" + this.index + "]  end.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static void main(String [] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for(int i = 1;i < 10;i ++){
			executorService.execute(new MyExector(i));
		}
		System.out.println("submit finished");
		executorService.shutdown();
	}
}
