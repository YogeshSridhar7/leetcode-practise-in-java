import javax.crypto.spec.PSource;
import java.util.List;

public class InnerClassDemo {
    public static void main(String[] args) {
        System.out.println("Main prints");
        List<Shape> i = List.of(new Shape(),new Circle(), new Square());
        i.stream().forEach(f -> f.draw());
    }
}
class Shape{
    private int d =7;
    void draw(){
        InnerShape innerShape = new InnerShape();
    }
    class InnerShape{
        void draw(){
            System.out.println("Inner dimension is" + d);
        }
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("Circle prints");
    }
}
class Square extends Shape{
    void draw(){
        System.out.println("Square prints");
    }
}