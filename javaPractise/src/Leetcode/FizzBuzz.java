package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.ternarySolution(15));
    }

    public List<String> solution(int n) {
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }

    public List<String> ternarySolution(int n) {
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            ans.add(
                    i % 15 == 0 ? "FizzBuzz" :
                            i % 5 == 0 ? "Buzz" :
                                    i % 3 == 0 ? "Fizz" :
                                            String.valueOf(i)
            );
        }
        return ans;
    }
}
