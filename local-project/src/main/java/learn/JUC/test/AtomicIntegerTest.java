package learn.JUC.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
*
* @author: liutaotao
* @date  : 2018年1月3日上午10:03:19
*
*/
public class AtomicIntegerTest {

	public static void main(String [] args) throws InterruptedException{
		// 初始值为0
		AtomicInteger atomicInteger = new AtomicInteger();
		int a = atomicInteger.getAndIncrement();
		int b = atomicInteger.incrementAndGet();
		System.out.println(a);
		System.out.println(b);
        final AtomicInteger value = new AtomicInteger(10);
        value.compareAndSet(10,11);
        System.out.println(value.get());
        final int threadSize = 100;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                }
            };
        }
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        System.out.println(value.get());
        System.out.println("------------");
        // 每个元素都是AtomicInteger类型
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
        atomicIntegerArray.set(0, 1);
        System.out.println(atomicIntegerArray.get(0));
          
	} 
}
