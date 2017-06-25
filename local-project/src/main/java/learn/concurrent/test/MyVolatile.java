package learn.concurrent.test;

/**
*
* @author: liutaotao
* @date  : 2017年6月24日下午5:08:31
*
*/
/**
 * volatile变量自身具有下列特性： 可见性。对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
 * 原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性。
 * 
 * volatile写的内存语义如下： 当写一个volatile变量时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存。
 * volatile读的内存语义如下： 当读一个volatile变量时，JMM会把该线程对应的本地内存置为无效。线程接下来将从主内存中读取共享变量。
 * 
 * 锁释放-获取与volatile的读写具有相同的内存语义，
 * 
 * 锁释放的内存语义如下： 当线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存。 锁获取的内存语义如下：
 * 当线程获取锁时，JMM会把该线程对应的本地内存置为无效，从而使得被监视器保护的临界区代码必须要从主内存中读取共享变量。
 * 
 * 
 */
public class MyVolatile {
	int x = 0;
	volatile int b = 0;

	private void write() throws InterruptedException {
		for (int i = 1; i < 100; i++) {
			Thread.sleep(1);
			x = 5;
			b = i;
		}
	}

	private void read() {
		for (int i = 1; i < 100; i++) {
			System.out.println("i:" + i + "b is " + b);
			int dummy = b;
			System.out.println("i:" + i + "b is " + dummy);
			while (x != 5) {
			}
		}
	}

	public static void main(String[] args) throws Exception {
		final MyVolatile example = new MyVolatile();
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try {
					example.write();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				example.read();
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}
}
