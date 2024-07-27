import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapDemo {
    public static void main(String[] args) {

        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::println);
        System.out.println();

        Stream.of("Dan","Ava","Rob")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
        
        String []names = {"Ava","Yan","Rem","Jim","Pam","Rae"};
        Arrays.stream(names)
                .filter(x->x.startsWith("R"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        List<String> name = Arrays.asList("Al","Joel","Rae","Nav","Jas","Rem","Pri");
        name
                .stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("j"))
                .forEach(System.out::println);
        System.out.println();

        List<String> name1 = Arrays.asList("Al","Joel","Rae","Nav","Jas","Rem","Pri");
        name1
                .stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("j"))
                .forEach(System.out::println);
        System.out.println();

        String s = null;
        Optional<String> s1 = Optional.ofNullable(s);
    }
}
