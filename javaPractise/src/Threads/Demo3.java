package Threads;

public class Demo3 implements Runnable{
    public void run() {
        System.out.println("Run");
        throw new RuntimeException("Problem");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Demo3());
        t.start();
        System.out.println("End of Method");
        Demo3 demo = new Demo3();
        A objectA = new A();
        objectA.waitForSignal();
    }

}

class A{
    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            obj.wait();
            obj.notify();
        }
    }
}
