package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午3:45:47
 *
 */
/**
 * 静态方上以及类上加的synchronized,作用于类上 A.
 * 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；
 * 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。 B.
 * 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。 C.
 * 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 *
 */
public class MySynchronizedOnClass implements Runnable {
	private static int count;

	public MySynchronizedOnClass() {
		count = 0;
	}

	public synchronized static void method() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + (count++));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void run() {
		method();
	}

	public static void main(String[] name) {
		MySynchronizedOnClass syncThread1 = new MySynchronizedOnClass();
		MySynchronizedOnClass syncThread2 = new MySynchronizedOnClass();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}

	public static void methods() {
		synchronized (MySynchronizedOnClass.class) { // 类上锁
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}