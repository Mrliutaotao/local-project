package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月21日下午3:29:29
 *
 */
public class MyThread {
	@SuppressWarnings("static-access")
	public static void mains(String s[]) {
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
		System.out.println("deamon" + current.isDaemon());
		System.out.println(current.getPriority());
		System.out.println(current.getName());
		System.out.println(current.activeCount());
		System.out.println(current.getId());
		System.out.println(current.getThreadGroup());
		System.out.println(current.getStackTrace());
		System.out.println(current.hashCode());
		System.out.println(current.toString());
	}
 	public static void main(String s[])  {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				int j = 0;
				for (int i = 1; i < 10000; i++) {
					 j++;
				}
				System.out.println("yeild start ... " );
				Thread.currentThread().yield();
				System.out.println("yeild end ... ");
				System.out.println("thread ... " + j);
			}
		});
		thread.setName("myThread");
		thread.start();
				
		/*thread.isAlive();
		thread.join();
		thread.interrupt();
		thread.isInterrupted();
		thread.yield();
		thread.notify();
		thread.notifyAll();
		thread.wait();
		thread.wait(100L);*/
		

		
		Thread current = Thread.currentThread();
		System.out.println("currnetThread " + current.getPriority());
		System.out.println("currnetThread " + current.getName());
		System.out.println("currnetThread " + current.activeCount());
		System.out.println("currnetThread " + current.getId());
		System.out.println("currnetThread " + current.getThreadGroup());
		System.out.println("currnetThread " + current.getStackTrace());
		System.out.println("currnetThread " + current.hashCode());
		System.out.println("currnetThread " + current.toString());
		System.out.println("currnetThread " + current.getState());
		System.out.println("currnetThread " + current.activeCount());
		System.out.println("thread is alive " + thread.isAlive());
	 
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

