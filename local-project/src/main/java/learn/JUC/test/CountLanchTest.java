package learn.JUC.test;

import java.util.concurrent.CountDownLatch;

import org.junit.experimental.theories.Theories;

/**
*
* @author: liutaotao
* @date  : 2018年1月11日下午5:43:25
*
*/
public class CountLanchTest {

	public static void main(String [] arg) throws InterruptedException{
		CountLanchTest countLanchTest = new CountLanchTest();
		countLanchTest.timecost(2,new Runnable() {
			public void run() {
				System.out.println("a");
			}
		});
	}

    public long timecost(final int times, final Runnable task) throws InterruptedException {
        if (times <= 0) throw new IllegalArgumentException();
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        task.run();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } finally {
                        overLatch.countDown();
                    }
                }
            }).start();
        }
        long start = System.nanoTime();
        startLatch.countDown();
        overLatch.await();
        return System.nanoTime() - start;
    }
}
