package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContaining {
    public static void main(String[] args) {
        FindWordsContaining word = new FindWordsContaining();
        String[] words = {"leet","code","bbbbb","ababa","answer"};
        char x = 'e';
        List<Integer> ans = word.sollution(words,x);
        System.out.println(ans);
    }
    public List<Integer> sollution(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    answer.add(i);
                    break;
                }
            }
        }
        return answer;
    }
}
