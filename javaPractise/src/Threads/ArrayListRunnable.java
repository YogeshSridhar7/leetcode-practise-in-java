package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayListRunnable implements Runnable {
    private List<Integer> list = new ArrayList<>();

    public ArrayListRunnable() {
        for (int i=0; i< 100; i++) {
            System.out.println(Thread.currentThread().getName()+list.add(i));
        }
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        while (!list.isEmpty()) {
            System.out.println(tName + " removed " + list.remove(0));
        }
    }

    public static void main(String[] args) {
        ArrayList a = new ArrayList<>(10);
        System.out.println(a.size());
        for (int i =0;i<15; i++){
            a.add(i);
        }
        System.out.println(a.size());
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(2);
        try {
            bq.put(42);
           // bq.remove(42);
            bq.put(43);
        } catch (InterruptedException ex) {}
        ArrayListRunnable alr = new ArrayListRunnable();
        Thread t1 = new Thread(alr);
        Thread t2 = new Thread(alr);
        t1.setName("Tee");
        t2.setName("Hee");
        t1.start();
        t2.start();
    }
}
