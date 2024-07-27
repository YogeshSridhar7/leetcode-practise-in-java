package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        System.out.println("The Integer of the Roman number is : "+r.romanToInt("MCMXCIII"));
        System.out.println("The Integer of the Roman number is : "+r.romanToInt("MCMXCIX"));
    }

    public int romanToInt(String s) {
        Map<String,Integer> input = new HashMap<>();
        input.put("I",1);
        input.put("V",5);
        input.put("X",10);
        input.put("L",50);
        input.put("C",100);
        input.put("D",500);
        input.put("M",1000);

        int ans=0;
        if(input.containsKey(s)){
            return input.get(s);
        }
        System.out.println("String length: " +s.length());

        for (int i = 0; i < s.length(); i++) {
            int s1 = input.get(String.valueOf(s.charAt(i)));
            if (i+1 < s.length()) {
                int s2 = input.get(String.valueOf(s.charAt(i+1)));
                if (s1>=s2){
                    ans += s1;
                }
                else {
                    ans = ans + s2-s1;
                    i++;
                }
            }else{
                ans += s1;
            }
        }
        return ans;
    }
}
