package Leetcode;

/*
1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
2. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
3. Those numbers for which this process ends in 1 are happy.
*/
public class HappyNumber {

    public boolean isHappy(int n){
        int first =n;
        int second =n;

        do{
            first = square(first);
            second = square(square(second));
        } while (first!=second);

        if(first==1){
            return true;
        }
        return false;
    }
     public int square(int num) {
        int ans = 0;
        while(num>0){
            int rem = num%10;
            ans += rem*rem;
            num /= 10;
        }
        return ans;
     }

    public static void main(String[] args) {
        HappyNumber number = new HappyNumber();
        System.out.println(number.isHappy(19));
    }
}
