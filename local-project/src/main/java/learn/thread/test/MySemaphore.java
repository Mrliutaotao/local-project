package learn.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
*
* @author: liutaotao
* @date  : 2017年6月20日下午4:20:07
*
*/
public class MySemaphore extends Thread{
	
	int index;
	Semaphore position;
	
	public MySemaphore(int index,Semaphore position) {
		this.index = index;
		this.position = position;
	}
	
	public void run() {
		try {
			if (position.availablePermits() > 0) {
				System.out.println("顾客[" + this.index + "]进入厕所，有空位");
			}else {
				System.out.println("顾客[" + this.index + "]进入厕所，没空位，排队");
			}
			position.acquire();
			System.out.println(position);
			System.out.println("顾客[" + this.index + "]获得坑位");
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("顾客[" + this.index + "]使用完毕");
			position.release();
			System.out.println(position);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		ExecutorService list = Executors.newCachedThreadPool();
		Semaphore position = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			list.submit(new MySemaphore(i + 1, position));
		}
		list.shutdown();
		position.acquireUninterruptibly(2);
		System.out.println(position);
		System.out.println("使用完毕，需要清扫了");
		position.release(2);
		System.out.println(position);
	}
}
