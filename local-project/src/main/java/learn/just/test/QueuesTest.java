package learn.just.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月30日下午5:56:13
 * @desc:
 */
public class QueuesTest {

	
	public static void main(String[] args) {
		Queue queue = new ArrayDeque<String>();
		 
		queue.add("a");
		queue.add("b");
		queue.add("c");
		System.out.println(queue.peek());
		queue.poll();
		queue.add("d");
		System.out.println(queue);
		
		ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<String>(5);

	}

}
