package learn.JUC.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
*
* @author: liutaotao
* @date  : 2018年1月3日上午10:03:19
*
*/
public class AtomicIntegerTest {
	private static volatile int val = 0;
	public static void main(String [] args) throws InterruptedException{
		// 初始值为0
		AtomicInteger atomicInteger = new AtomicInteger();
		int a = atomicInteger.getAndIncrement();
		int b = atomicInteger.incrementAndGet();
		System.out.println(a);
		System.out.println(b);
        AtomicInteger value = new AtomicInteger(10);
        value.compareAndSet(10,11);
        System.out.println(value.get());
      
        final AtomicInteger values = new AtomicInteger(0);
        final int threadSize = 1000;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
					for (int j = 1; j <= 1000; j++) {
                    	values.incrementAndGet();
                    	val++;
                	}
                }
            };
            ts[i].start();
        }
        
        for(Thread t:ts) {
            t.join();
        }
        System.out.println(val);
        System.out.println(values);
        
        System.out.println(value.get());
        System.out.println("------------");
        // 每个元素都是AtomicInteger类型
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
        atomicIntegerArray.set(0, 1);
        System.out.println(atomicIntegerArray.get(0));
          
	} 
}
