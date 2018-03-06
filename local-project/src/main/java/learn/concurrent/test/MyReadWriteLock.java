package learn.concurrent.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
*
* @author: liutaotao
* @date  : 2018年1月15日下午8:03:00
*
*/
public class MyReadWriteLock {

	public static void main(String[] args) {
		ReadWriteLock readwriteLock = new ReentrantReadWriteLock();
		readwriteLock.readLock().lock();
	}

}
