package Threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread( ()-> {
            c.insertIntoMap(0,1);
            c.insertIntoMap(1,2);
            c.insertIntoMap(2,3);
            c.insertIntoMap(7,8);
            c.insertIntoMap(6,100);
            c.insertIntoMap(4,11);
            c.insertIntoMap(5,89);
            c.insertIntoMap(5,89);
            c.insertIntoMap(5,89);
            c.insertIntoMap(5,89);
            c.insertIntoMap(10,198);
            c.insertIntoMap(11,61);
            c.insertIntoMap(3,240);
            c.insertIntoMap(8,96);
            c.insertIntoMap(9,65);
        });
        Thread t2 = new Thread(() -> {
            for (int i =0; i<15; i++){
                System.out.println("Getting value from thread "
                        + Thread.currentThread().getName()
                        + " "
                        + c.getValueFromMap(i));
                c.insertIntoMap(5,88888);
            }
        });
        t1.setName("Thread_1");
        t2.setName("Thread_2");
        t1.start();
        t2.start();
        System.out.println(c.getMap());

    }
}
class Counter{
    private ConcurrentMap<Integer,Integer> map = new ConcurrentSkipListMap<>();
    public void insertIntoMap(int key, int value){
        map.put(key,value);
        System.out.println("Inserted in thread "
                + Thread.currentThread().getName()
                + map);
    }
    public Integer getValueFromMap(Integer key) {
        return map.get(key);
    }
    public ConcurrentMap<Integer,Integer> getMap(){
        return map;
    }
}