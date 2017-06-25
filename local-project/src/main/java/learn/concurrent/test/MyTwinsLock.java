package learn.concurrent.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月25日下午2:16:57
 *
 */
public class MyTwinsLock implements Lock {

	private final Sync sync = new Sync(2);

	private static final class Sync extends AbstractQueuedSynchronizer {
		private static final long serialVersionUID = -7889272986162341211L;

		Sync(int count) {
			if (count <= 0) {
				throw new IllegalArgumentException("count must large than zero.");
			}
			setState(count);
		}

		public int tryAcquireShared(int reduceCount) {
			for (;;) {
				int current = getState();
				int newCount = current - reduceCount;
				if (newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}
			}
		}

		public boolean tryReleaseShared(int returnCount) {
			for (;;) {
				int current = getState();
				int newCount = current + returnCount;
				if (compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}
	}

	public void lock() {
		sync.acquireShared(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireSharedInterruptibly(1);
	}

	public boolean tryLock() {
		return sync.tryAcquireShared(1) >= 0;
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
	}

	public void unlock() {
		sync.releaseShared(1);
	}

	public Condition newCondition() {
		return null;
	}

	public static void main(String[] name) {
		final Lock lock = new MyTwinsLock();

		class Worker extends Thread {
			public void run() {
				while (true) {
					lock.lock();
					try {
						System.out.println("lock start");
						Thread.sleep(1000L);
						System.out.println(Thread.currentThread());
						Thread.sleep(1000L);
						System.out.println("lock end");
					} catch (Exception ex) {

					} finally {
						lock.unlock();
					}
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			Worker w = new Worker();
			w.start();
		}

		new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(200L);
						System.out.println("---");
					} catch (Exception ex) {

					}
				}
			}
		}.start();

		try {
			Thread.sleep(20000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
