package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月21日下午3:29:29
 *
 */
public class MyThread {
	@SuppressWarnings("static-access")
	public static void main(String s[]) {
		System.out.println("thread");
		new Thread(new B("thread0")).start();
		new Thread(new B("thread1")).start();
		new Thread(new B("thread2")).start();
		new Thread(new B("thread3")).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread current = Thread.currentThread();
		System.out.println(current.getPriority());
		System.out.println(current.getName());
		System.out.println(current.activeCount());
		System.out.println(current.getId());
		System.out.println(current.getThreadGroup());
		System.out.println(current.getStackTrace());
		System.out.println(current.hashCode());
		System.out.println(current.toString());
	}
}

class B implements Runnable {
 	private String name;

	public B(String s) {
		this.name = s;
	}
	public void run() {
		System.out.println(this.name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}