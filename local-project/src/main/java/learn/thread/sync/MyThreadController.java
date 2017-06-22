package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午4:00:32
 *
 */
/*
 * 在Java的Object类中有三个final的方法允许线程之间进行资源对象锁的通信，他们分别是： wait(), notify() and
 * notifyAll()。
 * 调用这些方法的当前线程必须拥有此对象监视器，否则将会报java.lang.IllegalMonitorStateException
 * exception异常。
 * 此方法只应由作为此对象监视器的所有者的线程来调用。通过以下三种方法之一，线程可以成为此对象监视器的所有者：
 * 1.通过执行此对象的同步实例方法。 
 * 2.通过执行在此对象上进行同步的 synchronized 语句的正文。 
 * 3.对于 Class类型的对象，可以通过执行该类的同步静态方法
 */
public class MyThreadController {
	public static class Message {
		private String msg;

		public Message(String str) {
			this.msg = str;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String str) {
			this.msg = str;
		}
	}

	public static class Waiter implements Runnable {
		private Message msg;

		public Waiter(Message m) {
			this.msg = m;
		}

		public void run() {
			String name = Thread.currentThread().getName();
			synchronized (msg) {
				try {
					System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
					msg.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " waiter thread got notified at time:" + System.currentTimeMillis());
				// process the message now
				System.out.println(name + " processed: " + msg.getMsg());
			}
		}
	}

	public static class Notifier implements Runnable {

		private Message msg;

		public Notifier(Message msg) {
			this.msg = msg;
		}

		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");
			try {
				Thread.sleep(1000);
				synchronized (msg) {
					msg.setMsg(name + " Notifier work done");
					// msg.notify(); // 只唤醒一个等待的,只会有一个被激活,另一个一直等待
					msg.notifyAll();// 唤醒全部等待的
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		Message msg = new Message("process it");
		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}

}
