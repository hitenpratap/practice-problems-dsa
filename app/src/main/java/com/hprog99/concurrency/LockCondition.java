package com.hprog99.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    private final Lock lock = new ReentrantLock();
    private final Condition notZero = lock.newCondition();
    private final Condition notAtLimit = lock.newCondition();

    private final int limit = 50;
    private int count = 0;

    public int increment() throws InterruptedException {
        lock.lock();
        try {
            while (count == limit) {
                notAtLimit.await();
            }

            count++;
            notZero.signalAll();

            return count;
        } finally {
            lock.unlock();
        }
    }

    public int decrement() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notZero.await();
            }

            count--;
            notAtLimit.signalAll();
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockCondition lc = new LockCondition();
        ExecutorService executer = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executer.submit(() -> lc.increment());
        }

        executer.submit(() -> lc.decrement());
        executer.submit(() -> lc.decrement());

        executer.shutdownNow();
        executer.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Count: " + lc.count);
    }
}
