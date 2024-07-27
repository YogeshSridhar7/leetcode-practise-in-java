package Threads;

public class ThreadPractise {
    public static void main(String[] args) {

    }
}

class Thread1 extends Thread{

}

class Thread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Using Runnable interface");
    }
}