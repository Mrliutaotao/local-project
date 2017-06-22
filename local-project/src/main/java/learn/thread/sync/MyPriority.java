package learn.thread.sync;


/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午4:48:36
 *
 */
/*
 * Thread类提供了三个表示优先级的常量：
 * MIN_PRIORITY优先级最低，为1；
 * NORM_PRIORITY是正常的优先级；为5，
 * MAX_PRIORITY优先级最高，为10。
 * 我们创建线程对象后，如果不显示的设置优先级的话，默认为5。
 */
public class MyPriority implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public static void main(String[] a) {
		//创建三个线程
		Thread thread1 = new Thread(new MyPriority(), "Thread1");
		Thread thread2 = new Thread(new MyPriority(), "Thread2");
		Thread thread3 = new Thread(new MyPriority(), "Thread3");
		//设置优先级
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(8);
		//开始执行线程
		thread3.start();
		thread2.start();
		thread1.start();
	}
}
