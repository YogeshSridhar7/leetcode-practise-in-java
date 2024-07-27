package Threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreadDeadlock{
    public static void main(String[] args) {
        ThreadDeadlock deadlock =new ThreadDeadlock();
        ThreadDeadlock deadlock1 =new ThreadDeadlock();
        Thread one = new Thread(() -> {
            deadlock.write(1,3);
        }) ;
        Thread two = new Thread(() -> {
            deadlock1.read();
        });
        one.start();
        two.start();
    }
//
//    @Override
//    public void run() {
//        System.out.println(read());
//        write(1,2);
//        System.out.println(read());
//    }

    private static class Resource {
        public int value;
    }
    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();
    private int read() {
        synchronized (resourceA) {
            synchronized (resourceB){
                return resourceB.value + resourceA.value;
            }
        }
    }
    public void write(int a, int b){
        synchronized (resourceB){
            synchronized (resourceA){
                resourceA.value = a;
                resourceB.value = b;
            }
        }
        List<String> names = Collections.synchronizedList(new LinkedList<>());
    }
}
