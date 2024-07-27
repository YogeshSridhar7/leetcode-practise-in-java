package Leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class  Decode {
    public static void main(String[] args) {
        Map<Integer,String> input = new TreeMap<>();
        input.put(3, "love");
        input.put(6, "computers");
        input.put(2, "dogs");
        input.put(4, "cats");
        input.put(1, "I");
        input.put(5, "you");
        System.out.println(input);
        List<Integer> arr = input.keySet().stream().collect(Collectors.toList());
        System.out.println(arr);
        int i=1;
        System.out.println(input.get(arr.get(i)));
        for(int j=0;j<arr.size();j=j+i){
            i++;
            System.out.println(input.get(arr.get(j)));
        }
    }
}
