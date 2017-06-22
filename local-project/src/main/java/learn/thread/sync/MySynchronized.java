package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午3:29:57
 *
 */
/*
 * 代码块上的同步是对象级别的同步,只作用于同一个对象上,对于线程访问非同步代码块无限制 对于不同的对象,无同步机制
 */
public class MySynchronized implements Runnable {
	private static int count;

	public MySynchronized() {
		count = 0;
	}

	public void run() {
		synchronized (this) {// this指针对象
			// synchronized (new Object()) { // 指定对象
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

	public int getCount() {
		return count;
	}

	public static void main(String[] name) {
		// synchronized 对象上的同步
		MySynchronized thread = new MySynchronized();
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		thread1.start();
		thread2.start();
		// synchronized 非同步
		/*
		 * Thread thread1 = new Thread(new MySynchronized()); Thread thread2 =
		 * new Thread(new MySynchronized()); thread1.start(); thread2.start();
		 */
	}

	/**
	 * 在用synchronized修饰方法时要注意以下几点： 1. synchronized关键字不能继承。
	 * 虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
	 * 因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，
	 * 而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个方法
	 * 中加上synchronized关键字才可以。当然，还可以在子类方法中调用父类中相应的方法，这样虽然子
	 * 类中的方法不是同步的，但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了。这两种方式的例子代码如下：
	 * 在子类方法中加上synchronized关键字 
	 * class Parent { public synchronized void method(){} } 
	 * class Child extends Parent { public synchronized void method() { }}
	 * 在子类方法中调用父类的同步方法
	 * class Parent { public synchronized void method() { } }
	 * class Child extends Parent { public void method() { super.method(); } }
	 */
	public synchronized void run1() {
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
