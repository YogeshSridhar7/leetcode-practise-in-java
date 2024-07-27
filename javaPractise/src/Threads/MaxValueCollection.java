package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MaxValueCollection {

    public static void main(String[] args) throws InterruptedException {
        MaxValueCollection m = new MaxValueCollection();

        Thread t1 = new Thread(() -> {
            m.add(05);
            m.add(43);
            m.add(44);
            m.add(07);
            System.out.println(Thread.currentThread().getName() + m.findMax());
        });
        t1.setName("Tee");

        Thread t2 = new Thread(() -> {
            m.add(10);
            m.add(11);
            System.out.println(Thread.currentThread().getName() + m.findMax());
        });
        t2.setName("Hee");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(m.findMax());
    }

    private List<Integer> integers = new ArrayList<>();
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public void add(Integer i) {
        rwl.writeLock().lock();
        try {
            if(rwl.isWriteLocked()) {
                integers.add(i);
            }
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public int findMax() {
        rwl.readLock().lock();
        try {
            return Collections.max(integers);
        } finally {
            rwl.readLock().unlock();
        }
    }
}
