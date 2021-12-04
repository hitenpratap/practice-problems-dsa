package com.hprog99.concurrency;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLocks {
    private Integer count = 0;
    final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " is calling => increment()");
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLocks reentrantLocks = new ReentrantLocks();
        Thread threadA = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                reentrantLocks.increment();
            });
        });
        Thread threadB = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                reentrantLocks.increment();
            });
        });
        Thread threadC = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                reentrantLocks.increment();
            });
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println(reentrantLocks.count);
    }
}
