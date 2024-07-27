public class TestDemo2 {
    String message = "Parent class";
    public TestDemo2(String message){
        this.message = message;
    }

    public static void main(String[] args) {

    }
}

class TestDemo3 extends TestDemo2{
    String message = "Child class";
    public TestDemo3(String message) {
        super(message);
    }
    public void getParentMessage(){
        System.out.println(super.message);
    }
}