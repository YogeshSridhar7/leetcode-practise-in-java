public class VolatileExample {

    public static transient boolean flag = false;
    public static void main(String[] args) {
        System.out.println(flag +"IS TRUE22222222222222222222222222222222");
        new Thread(() -> {
            while (!flag) {
                System.out.println("Not surrendered");
            }
            System.out.println("Thread Finished");
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
    }
}
