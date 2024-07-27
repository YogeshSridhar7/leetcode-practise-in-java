package Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamsDemo2 {
    public static void main(String[] args) {
        List<Double> tempsInLondon = Arrays.asList(11.0,15.0,12.0,1.0,24.0,22.0,25.5,8.6,5.7);
        System.out.println("Number of days over 10.0 : " +
        tempsInLondon
                .stream()
                .filter(t -> t > 10.0)
                .count());
        System.out.println();

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("A",1);
        myMap.put("B",2);
        myMap.put("I",9);
        myMap.put("C",3);
        myMap.put("J",10);
        System.out.println("Number of items in the map > 9 : " +
                myMap
                        .entrySet()
                        .stream().filter(n -> n.getValue() < 9)
                        .count()
        );
        System.out.println();

        List<String> names = Arrays.asList("AAmb","AALoo","Rae","Rem","temp","Grace","Rem","Cee");
        names
                .stream()
                .filter(s -> s.startsWith("R") || s.startsWith("C"))
                .filter(s -> s.length() >3)
                .forEach(System.out::println);
    }
}
