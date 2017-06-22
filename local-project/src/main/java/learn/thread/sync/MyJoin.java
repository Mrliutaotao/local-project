package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午4:43:44
 *
 */
/*
 * join 合并，就是等待其它(调用此方法的线程)线程执行完，再返回执行当前线程，执行起来的效果就好像把其它线程合并到当前线程执行一样 public
 * final void join() 等待该线程终止 public final void join(long millis); 等待该线程终止的时间最长为
 * millis 毫秒。超时为 0 意味着要一直等下去。 public final void join(long millis, int nanos)
 * 等待该线程终止的时间最长为 millis 毫秒 +nanos 纳秒
 */
public class MyJoin {
	static class Plugin1 implements Runnable {
		public void run() {
			System.out.println("插件1开始安装.");
			System.out.println("安装中...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("插件1完成安装.");
		}
	}

	/**
	 * 插件2
	 */
	static class Plugin2 implements Runnable {
		public void run() {
			System.out.println("插件2开始安装.");
			System.out.println("安装中...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("插件2完成安装.");
		}
	}

	public static void main(String[] a) {
		System.out.println("主线程开启...");
		Thread thread1 = new Thread(new Plugin1());
		Thread thread2 = new Thread(new Plugin2());
		try {
			thread1.start(); // 开始插件1的安装
			thread1.join();  // 等插件1的安装线程结束,才能返回主线程
			thread2.start(); // 再开始插件2的安装
			thread2.join();  // 等插件2的安装线程结束,才能回到主线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程结束，程序安装完成！");
	}
}
