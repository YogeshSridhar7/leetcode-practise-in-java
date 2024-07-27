public class InterfaceDemo {
    public static void main(String[] args) {
        Pizza z = new Pizza();
        Pizza.Cheese c = new Pizza.Cheese();


    }
}
class Food{
    public void foodType(){

    }
}
class Pizza {
    static class Cheese{
        static void eat(){
            System.out.println("I eat Pizza.");
        }
    }
}
