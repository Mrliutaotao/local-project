package learn.thread.sync;

/**
 *
 * @author: liutaotao
 * @date : 2017年6月21日下午3:45:30
 *
 */
public class MyThreadInterrupt extends Thread {

	@Override
	public void run() {
		
	}

	public static void main(String[] args) {
		Thread myThread = new MyThreadInterrupt();
		myThread.start();
	}
}
