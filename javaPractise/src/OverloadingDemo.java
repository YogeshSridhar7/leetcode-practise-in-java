public class OverloadingDemo {
    public static void main(String[] args) {
        OverloadingDemo overloadingDemo = new OverloadingDemo();
        int o = overloadingDemo.multiply(1,2,3);
        System.out.println(o);
    }
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
    public String accelerate(long mph) {
        return "The vehicle accelerates at : " + mph + " MPH.";
    }

    public String stop() {
        return "The vehicle has stopped.";
    }

    public String run() {
        return "The vehicle is running.";
    }
}

class Overriding extends OverloadingDemo{
    @Override
    public String accelerate(long mph) {
        return "The car accelerates at : " + mph + " MPH.";
    }
}
