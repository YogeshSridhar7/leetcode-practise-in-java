package Threads;

public class ThreadWait {
    public static void main(String[] args) {
        ThreadC c = new ThreadC();
        ThreadC c1 = new ThreadC();
        c.setName("Thread1");
        c1.setName("Thread2");
        c.start();
        c1.start();

        synchronized (c){
            try{
                System.out.println("Waiting for c to complete..." + Thread.currentThread().getName());
                c.wait();
            } catch (InterruptedException e) {}
            System.out.println("Total is " + c.total);
        }
    }
}

class ThreadC extends Thread{
    int total;
    @Override
    public void run() {
        synchronized (this){
            for(int i=0; i<10000; i++){
                total+=i;
            }
            System.out.println("Completed loop : " + Thread.currentThread().getName());
            notify();
        }
    }
}
