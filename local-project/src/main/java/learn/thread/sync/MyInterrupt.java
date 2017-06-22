package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月22日下午4:36:01
 *
 */
/*
 * 在Java提供的线程支持类Thread中，有三个用于线程中断的方法： 
 * public void interrupt(); 中断线程。
 * public static boolean interrupted(); 是一个静态方法，用于测试当前线程是否已经中断，并将线程的中断状态
 *    清除。所以如果线程已经中断，调用两次interrupted，第二次时会返回false，因为第一次返回true后会清除中断状态。 
 * public boolean isInterrupted(); 测试线程是否已经中断。
 */
public class MyInterrupt implements Runnable{
	public void run() {
	      while (!Thread.currentThread().isInterrupted()) {     //如果当前线程未被中断，则执行打印工作
	         System.out.println(Thread.currentThread().getName() + "打印中… …");
	      }
	      if (Thread.currentThread().isInterrupted()) {
	         System.out.println("interrupted:" +  Thread.interrupted());       //返回当前线程的状态，并清除状态
	         System.out.println("isInterrupted:" +  Thread.currentThread().isInterrupted());
	      }
	   }
	public static void main(String [] a){
		MyInterrupt printer = new MyInterrupt();
		Thread printerThread = new Thread(printer, "打印线程");
		printerThread.start();
		try {
		   Thread.sleep(100);
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
		System.out.println("有紧急任务出现，需中断打印线程.");
		System.out.println("中断前的状态：" + printerThread.isInterrupted());
		printerThread.interrupt();       // 中断打印线程
		System.out.println("中断后的状态：" + printerThread.isInterrupted());
	}
}
