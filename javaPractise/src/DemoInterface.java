import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface A{
    void show();
    String toString();
}

/*class B implements A{
    @Override
    public void show() {
        System.out.println("OBJECT of an interface cannot be created, " +
                "but rather an implementation can be created and then the object.");
    }
}*/

public class DemoInterface {
    public static void main(String[] args) {

        // Error will be given as an object of interface cannot be created
        //A obj = new A();

        /*A obj = new A() {
            @Override
            public void show() {
                System.out.println("Old Implementation using Anonymous Inner Classes, used in Java7");
            }
        };*/

        A obj = () -> System.out.println("Using lambda expressions");
        obj.show();

        Supplier<String> supplier = () -> {
            Map<String, String> env = System.getenv();
            return env.get("USER");
        };
        System.out.println("User is: " + supplier.get());

        Consumer<String> redOrBlue = pill -> {
            if (pill.equals("red")){
                System.out.println("RED");
            } else if (pill.equals("blue")) {
                System.out.println("Down the rabbit hole");
            }
            };
        redOrBlue.accept("blue");

        List<String> trees = Arrays.asList("fir", "pine", "teak", "oak");

        System.out.println("Using Lambda Expression");
        trees.forEach(tree -> System.out.println(tree)); /*Using Lambdas*/

        System.out.println("Using Method References");
        trees.forEach(System.out::println); /*Using Method Referencing*/
        System.out.println();
        System.out.println();
        }
    }