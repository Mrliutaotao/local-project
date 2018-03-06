package learn.threadPool.test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.fastjson.parser.Feature;

 
/**
*
* @author: liutaotao
* @date  : 2018年1月15日下午9:13:48
*
*/
public class ExecutorTest {
	public static void main(String [] args){
		ExecutorService executeService = Executors.newFixedThreadPool(9);
		Future<?> aFuture = (Future<?>) executeService.submit(new Runnable() {
			public void run() {
			System.out.println("aaa");
			}
		});
		System.out.println(aFuture.isDone());
		
		executeService.submit(new Callable<Feature>() {
			public Feature call() throws Exception {
				System.out.println("bbb");
				return null;
			}
		});
		 
		
		Executor ex;
 		
	}
}
