package Threads;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        ThreadA threadDemo = new ThreadA();
        threadDemo.setName("JavaThread");
        threadDemo.setPriority(10);
        threadDemo.start();
        threadDemo.run("2");
//        threadDemo.join();
        System.out.println(threadDemo.isAlive());


        ThreadB threadB = new ThreadB();
        Thread t = new Thread(threadB);
        t.start();
//        t.join();

        Runnable runnable = () -> {
            for (int i =0; i<4; i++)
            System.out.println("Using lambda " + i);
        };
        Thread r = new Thread(runnable);
        r.setPriority(1);
        r.start();
//        r.join();

        System.out.println("Completed main thread " + Thread.currentThread());
    }
}

class ThreadA extends Thread{
    @Override
    public void run(){
        for (int i =0; i<6; i++) {
            System.out.println("Threads.ThreadA is running " + this.getName() +i);
            try {
                Thread.sleep(5000);
            }catch (InterruptedException ex){}
            System.out.println("Threads.ThreadA woke up " + this.getName() +i);
        }


    }

    public void run(String s){
        System.out.println("Thread 2" + s);
    }
}

class ThreadB implements Runnable{
    @Override
    public void run() {
        System.out.println("Using an Interface");
    }
}