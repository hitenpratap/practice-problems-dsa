package com.hprog99.concurrency;

import java.util.stream.IntStream;

public class SyncClass {
    private Integer count = 0;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " is calling => increment()");
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncClass syncClass = new SyncClass();
        Thread threadA = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                syncClass.increment();
            });
        });
        Thread threadB = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                syncClass.increment();
            });
        });
        Thread threadC = new Thread(() -> {
            IntStream.range(0, 50000).forEach(i -> {
                syncClass.increment();
            });
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println(syncClass.count);
    }

}
