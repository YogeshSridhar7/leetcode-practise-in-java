package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) throws IOException {
        Integer[] myNums = {1,2,3,4,5,6,7,8,9};
        Stream<Integer> stream1 = Arrays.stream(myNums);
        long numElements = stream1
                .filter((i)->i<4)
                .count();
        System.out.println(stream1);
        System.out.println(numElements);
        numElements = Arrays.stream(myNums).filter((i) -> i>2).count();
        System.out.println("Number of elements > 10: " + numElements);

        Stream<Integer> stream2 = Stream.of(myNums);
        System.out.println(stream2);

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
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        List<String> name1 = Arrays.asList("Al","Joel","Rae","Nav","Jas","Rem","Pri");
        name
                .stream()
                .map(String::toLowerCase)
                .filter(s -> s.length()>2)
                .filter(s -> s.startsWith("R"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Stream<String> stream = Files.lines(Paths.get("D:\\Bournemouth\\Individual_Masters_Project\\projectIdea.txt"));
        stream.forEach(System.out::println);
    }
}