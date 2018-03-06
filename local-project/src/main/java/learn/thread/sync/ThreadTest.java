package learn.thread.sync;
/**
*
* @author: liutaotao
* @date  : 2018年1月10日上午11:56:05
*
*/
public class ThreadTest {

	public static void main(String[] args) {
		class myThread extends Thread{
			public int run(int a) {
				System.out.println("my thread run ...");
				return 0;
			}
			public void run() {
				System.out.println("my thread run ...");
 			}
			
		}
		Thread myThread = new myThread();
		myThread.start();
	}
}
