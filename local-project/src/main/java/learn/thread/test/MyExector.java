package learn.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月20日下午2:11:43
 *
 */
/* Exector
 * newFixedThreadPool（固定大小线程池）
 * 创建一个可重用固定线程集合的线程池，以共享的无界队列方式来运行这些线程（只有要请求的过来，就会在一个队列里等待执行）。
 * 如果在关闭前的执行期间由于失败而导致任何线程终止，那么一个新线程将代替它执行后续的任务（如果需要）。
 * newCachedThreadPool（无界线程池，可以进行自动线程回收）
 * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用
 * execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60
 * 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。注意，可以使用 ThreadPoolExecutor
 * 构造方法创建具有类似属性但细节不同（例如超时参数）的线程池。
 *  newSingleThreadExecutor（单个后台线程） 创建一个使用单个worker 线程的
 * Executor，以无界队列方式来运行该线程。（注意，如果因为在关闭前的执行期间出现失败而终止了此单个线程，那么如果需要，一个新线程将代替它执行后续的任务
 * ）。可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。与其他等效的 newFixedThreadPool(1)
 * 不同，可保证无需重新配置此方法所返回的执行程序即可使用其他的线程。
 * 这些方法返回的都是ExecutorService对象，这个对象可以理解为就是一个线程池。
 * 这个线程池的功能还是比较完善的。可以提交任务submit()可以结束线程池shutdown()。
 */
/*
 * 可以关闭 ExecutorService，这将导致其拒绝新任务。提供两个方法来关闭 ExecutorService。shutdown()
 * 方法在终止前允许执行以前提交的任务，而 shutdownNow()
 * 方法阻止等待任务启动并试图停止当前正在执行的任务。在终止时，执行程序没有任务在执行，也没有任务在等待执行，并且无法提交新任务。应该关闭未使用的
 * ExecutorService 以允许回收其资源。
 * 通过创建并返回一个可用于取消执行和/或等待完成的 Future，方法 submit 扩展了基本方法
 * Executor.execute(java.lang.Runnable)。方法 invokeAny 和 invokeAll
 * 是批量执行的最常用形式，它们执行任务 collection，然后等待至少一个，或全部任务完成（可使用 ExecutorCompletionService
 * 类来编写这些方法的自定义变体）。
 * 
 */
public class MyExector extends Thread {

	int index;

	public MyExector(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		try {
			Thread thread = Thread.currentThread();
			System.out.println(thread.getName());
			System.out.println("[" + this.index + "]  start....");
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("[" + this.index + "]  end.");
			thread.interrupt();
			System.out.println("stop thread"+thread.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int i = 1; i < 30; i++) {
			// void execute(Runnable command) 在未来某个时间执行给定的命令。
			executorService.execute(new MyExector(i));
			// 提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
			// executorService.submit(new MyExector(i));
		}
		System.out.println("submit finished");
		// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
		executorService.shutdown();
	}
}
/*
 * submit finished
[1]  start....
[2]  start....
[2]  end.
[3]  start....
[1]  end.
[4]  start....
[5]  start....
[6]  start....
[3]  end.
[4]  end.
[5]  end.
[7]  start....
[8]  start....
[8]  end.
[6]  end.
[7]  end.
[9]  start....
[9]  end.
*/