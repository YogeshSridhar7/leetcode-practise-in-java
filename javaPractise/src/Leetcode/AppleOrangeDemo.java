package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AppleOrangeDemo {
    public static void main(String[] args) {

        HashMap<String,String> appleOrange = new HashMap<>();
        appleOrange.put("a","orange");
        appleOrange.put("o","apple+orange");
        appleOrange.put("a+o","apple");
        boolean isFalse = false;
        for (Map.Entry<String, String> entry : appleOrange.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + value);
            if(key.equals("a") && !value.equals("apple")){
                isFalse = true;
            } else if(key.equals("o") && !value.equals("orange")){
                isFalse = true;
            } else if(key.equals("a+o") && !value.equals("apple+orange")){
                isFalse = true;
            }
        }

        System.out.println(appleOrange);
        System.out.println(isFalse + ", that the box has wrong labels");
        String firstSelection = appleOrange.get("a+o");
        System.out.println(firstSelection);

        if(firstSelection.equals("orange") || firstSelection.equals("apple")){
            appleOrange.replace("o","orange");
            appleOrange.replace("a","apple");
            appleOrange.replace("a+o","apple+orange");
        }
        System.out.println(appleOrange);
    }
}
