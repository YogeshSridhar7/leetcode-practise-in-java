package Leetcode;

public class FirstOccurrence {

    public int strStr(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i =0; i<= haystack.length()-needle.length(); i++){
            int j=0;
            while (j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sad";
        String needle = "sad";
        /*Leetcode.FirstOccurrence word = new Leetcode.FirstOccurrence();
        System.out.println(word.strStr("sadbutsad","sad"));*/

        if(haystack.contains(needle)){
            System.out.println(haystack.indexOf(needle));
        } else {
            System.out.println("-1");
        }
    }
}
