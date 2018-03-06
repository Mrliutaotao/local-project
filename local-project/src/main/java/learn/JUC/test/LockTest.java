package learn.JUC.test;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
*
* @author: liutaotao
* @date  : 2018年1月3日上午11:13:35
*
*/
public class LockTest {
 	static  int staticValue = 0;
	public static void main(String [] arg) throws InterruptedException{
		final Lock reentrantlock = new ReentrantLock();
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				try {
					// reentrantlock.lock();
					for (int i = 1; i < 1000; i++){
						System.out.println("a");
					}
				} catch (Exception e) {

				}finally {
					// reentrantlock.unlock();
				}
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			public void run() {
				try {
					//reentrantlock.lock();
					for (int i = 1; i < 1000; i++){
						System.out.println("b");
					}
				} catch (Exception e) {

				}finally {
					// reentrantlock.unlock();
				}
			}
		});
		
		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		
		
		try {
			
		} catch (Exception e) {
			 
		}finally {
			reentrantlock.unlock();
		}
		Condition condition = reentrantlock.newCondition();
		condition.await();

		final int max = 10;
		final int loopCount = 100000;
		long costTime = 0;
		final AtomicInteger value1 = new AtomicInteger(0);
		for (int m = 0; m < max; m++) {
			long start1 = System.nanoTime();
			Thread[] ts = new Thread[max];
			for (int i = 0; i < max; i++) {
				ts[i] = new Thread() {
					public void run() {
						for (int i = 0; i < loopCount; i++) {
							value1.incrementAndGet();
						}
					}
				};
			}
			for (Thread t : ts) {
				t.start();
			}
			for (Thread t : ts) {
				t.join();
			}
			long end1 = System.nanoTime();
			costTime += (end1 - start1);
		}
		System.out.println("cost1: " + (costTime));

		System.out.println(value1);
		costTime = 0;

		final Object lock = new Object();

		for (int m = 0; m < max; m++) {
			staticValue = 0;
			long start1 = System.nanoTime();
			Thread[] ts = new Thread[max];
			for (int i = 0; i < max; i++) {
				ts[i] = new Thread() {
					public void run() {
						for (int i = 0; i < loopCount; i++) {
							synchronized (lock) {
								++staticValue;
							}
						}
					}
				};
			}
			for (Thread t : ts) {
				t.start();
			}
			for (Thread t : ts) {
				t.join();
			}
			long end1 = System.nanoTime();
			costTime += (end1 - start1);
		}
		System.out.println("cost2: " + (costTime));
		System.out.println(staticValue);
		/*
		 * cost1: 331160750 
		 * 10000000 
		 * cost2: 627217300 
		 * 1000000
		 */
	}
	
	private class myThread extends Thread{
		
	}
}

