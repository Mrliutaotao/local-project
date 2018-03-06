package learn.concurrent.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
*
* @author: liutaotao
* @date  : 2018年1月18日下午8:57:09
*
*/
public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
		ConcurrentLinkedQueue conq = new ConcurrentLinkedQueue<>();
		conq.add("a");
		
		PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
		priorityBlockingQueue.add("a");
	}

}
