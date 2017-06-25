package learn.concurrent.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月25日下午1:37:46
 *
 */
/*
 * AQS使用一个整型的volatile变量（命名为state）来维护同步状态，这是接下来实现大部分同步需求的基础。
 * 提供了一个基于FIFO队列，可以用于构建锁或者其他相关同步装置的基础框架。使用的方法是继承，
 * 子类通过继承同步器并需要实现它的方法来管理其状态，管理的方式就是通过类似acquire和release的方式来操纵状态。
 * 然而多线程环境中对状态的操纵必须确保原子性，因此子类对于状态的把握，需要使用这个同步器提供的以下三个方法对状态进行操作：
 * 
 * java.util.concurrent.locks.AbstractQueuedSynchronizer.getState()
 * 
 * java.util.concurrent.locks.AbstractQueuedSynchronizer.setState(int)
 * 
 * java.util.concurrent.locks.AbstractQueuedSynchronizer.compareAndSetState(int,
 * int)
 * 
 * 子类推荐被定义为自定义同步装置的内部类，同步器自身没有实现任何同步接口，它仅仅是定义了若干acquire之类的方法来供使用。
 * 该同步器即可以作为排他模式也可以作为共享模式，当它被定义为一个排他模式时，其他线程对其的获取就被阻止，而共享模式对于多个线程获取都可以成功。
 * 
 * 同步器是实现锁的关键，利用同步器将锁的语义实现，然后在锁的实现中聚合同步器。可以这样理解：锁的API是面向使用者的，
 * 它定义了与锁交互的公共行为，而每个锁需要完成特定的操作也是透过这些行为来完成的（比如：可以允许两个线程进行加锁，排除两个以上的线程），
 * 但是实现是依托给同步器来完成；同步器面向的是线程访问和资源控制，它定义了线程对资源是否能够获取以及线程的排队等操作。
 * 锁和同步器很好的隔离了二者所需要关注的领域，严格意义上讲，同步器可以适用于除了锁以外的其他同步设施上（包括锁）。
 * 同步器的开始提到了其实现依赖于一个FIFO队列，那么队列中的元素Node就是保存着线程引用和线程状态的容器，
 * 每个线程对同步器的访问，都可以看做是队列中的一个节点。
 */
public class MyAQS implements Lock, java.io.Serializable {
	// 内部类，自定义同步器
	private static class Sync extends AbstractQueuedSynchronizer {
		// 是否处于占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1; // state = 1 表示当前锁被占用
		}

		// 当状态为0的时候获取锁
		public boolean tryAcquire(int acquires) {
			assert acquires == 1; // Otherwise unused 互斥锁只能为1,true继续后续操作,否则抛出异常
			if (compareAndSetState(0, 1)) { // state 初始默认值是0,当为0时表示可以获取锁
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		// 释放锁，将状态设置为0
		protected boolean tryRelease(int releases) {
			assert releases == 1; // Otherwise unused
			if (getState() == 0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		// 返回一个Condition，每个condition都包含了一个condition队列
		Condition newCondition() {
			return new ConditionObject();
		}
	}

	// 仅需要将操作代理到Sync上即可
	private final Sync sync = new Sync(); // state 默认为0

	public void lock() {
		sync.acquire(1);
	}

	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	public void unlock() {
		sync.release(1);
	}

	public Condition newCondition() {
		return sync.newCondition();
	}

	public boolean isLocked() {
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}
}
