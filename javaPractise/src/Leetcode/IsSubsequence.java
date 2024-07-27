package Leetcode;

public class IsSubsequence {
    public boolean isEqual(String s,String t) {
        int i=0;
        int j=0;
        while (i < s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public static void main(String[] args) {
        IsSubsequence seq = new IsSubsequence();
        System.out.println(seq.isEqual("abc","asdbfg"));
    }
}
