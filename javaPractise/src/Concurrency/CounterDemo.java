package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        IncrementThread i1 = new IncrementThread(c);
        IncrementThread i2 = new IncrementThread(c);
        long start = System.currentTimeMillis();

        i1.start();
        i2.start();
        i1.join();
        i2.join();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end-start));
        System.out.println(c.getCount());
    }
}

class Counter{
    private int count;
    //private AtomicInteger count = new AtomicInteger();
    public synchronized void increment(){
        count++;
        //count.getAndIncrement();
    }
    public int getCount() {
        return count;
        //return count.intValue();
    }
}

class IncrementThread extends Thread{
    private Counter counter;
    public IncrementThread(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i=0; i<10000000;i++){
            counter.increment();
        }
    }
}
