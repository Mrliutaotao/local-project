package learn.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
*
* @author: liutaotao
* @date  : 2017年6月25日下午2:36:30
*
*/
/**
 * 
 * 与每次需要时都创建线程相比，线程池可以降低创建线程的开销，在线程执行结束后进行的是回收操作，
 * 提高对线程的复用。Java中主要使用的线程池是ThreadPoolExecutor，此外还有定时的线程池ScheduledThreadPoolExecutor。
 * 
 * Java里面线程池的顶级接口是Executor，但是严格意义上讲Executor并不是一个线程池，而只是一个执行线程的工具。
 * 真正的线程池接口是ExecutorService。
 * 
 * 比较重要的几个类：
 * 
 * ExecutorService 真正的线程池接口
 * ScheduledExecutorService和Time/TimeTask类似，解决需要任务重复执行的问题 ThreadPoolExecutor
 * ExecutorService的默认实现
 * SchedulesThreadPoolExecutor继承ThreadPoolExecutor的ScheduledExecutorService接口实现，周期性任务调度的类实现
 * 要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的，
 * 因此在Executors类里面提供了一些静态工厂，生成一些常用的线程池。
 * 
 * 1. newSingleThreadExecutor 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 * 
 * 2.newFixedThreadPool 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小
 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 * 
 * 3. newCachedThreadPool 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
 * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务
 * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 * 
 * 4.newScheduledThreadPool 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 * 
 * PS：但需要注意使用，newSingleThreadExecutor和newFixedThreadPool将超过处理的线程放在队列中，
 * 但工作线程较多时，会引起过多内存被占用，而后两者返回的线程池是没有线程上线的，所以在使用时需要当心， 创建过多的线程容易引起服务器的宕机。
 * 
 */
public class MyThreadPoolExecutor {
	// ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long
	// keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
	public static ExecutorService defaultThreadPool = new ThreadPoolExecutor(5, 100, 60L, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>());

	public static void threadPoolTest() {
		defaultThreadPool.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("a");
			}
		});
	}
	
	public static void main(String [] args) {
		threadPoolTest();
	}
}
