package Leetcode;

public class PerfectSquare {
     public int numSquares(int n){
         if(n == 0) return 0;
         if(n < 0) return Integer.MAX_VALUE;
         int ans = Integer.MAX_VALUE;
         for(int i=1;i*i<=n;i++) {
             ans = Math.min(
                     ans,
                     1 + numSquares(n-(i*i))
             );
         }
         return ans;
     }
    public static void main(String[] args) {
         PerfectSquare square = new PerfectSquare();
        System.out.println(square.numSquares(55));
    }
}
