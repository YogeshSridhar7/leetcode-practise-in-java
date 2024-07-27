package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwap {
    public static void main(String[] args) {

        int input[] = {2,4,5,1,3};
        Boolean visited[] = new Boolean[input.length];
        HashMap<Integer, Integer> pair = new HashMap<>();
        int count = 0;
        for(int i : input){
            pair.put(i,count++);
            visited[count++] = false;
        }
        int ans = 0;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (visited[i] || pair.get(input[i]) == i)
                continue;

            int j = i;
            int cycle = 0;
            while (!visited[j] ) {
                visited[j] = true;
                j = pair.get(input[j]);
                cycle++;
            }
            if (cycle > 0) {
                ans += (cycle - 1);
            }
        }
        System.out.println(ans);
    }
}
