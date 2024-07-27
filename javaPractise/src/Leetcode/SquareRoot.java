package Leetcode;

public class SquareRoot {

    public int mySqrt(int x) {
        int start=1, end=x, mid, sqrt =1;

        if(x == 0 || x == 1){
            sqrt = x;
        }
        while (start <= end) {
            // Calculate the middle point using "start + (end - start) / 2" to avoid integer overflow.
            mid = start + (end - start) / 2;

            // If the square of the middle value is greater than x, move the "end" to the left (mid - 1).
            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                // If the square of the middle value is equal to x, we found the square root.
                return mid;
            else
                // If the square of the middle value is less than x, move the "start" to the right (mid + 1).
                start = mid + 1;
        }

        return Math.round(sqrt);
    }

    public static void main(String[] args) {

        SquareRoot squareRoot = new SquareRoot();
        System.out.println("The square root of the number is " + squareRoot.mySqrt(4));
        /*for(int i =1;i<=x;i++){
            if(x%i==0){
                if (i*i==x){
                    sqrt=i;
                }
            }
        }
        System.out.println(sqrt);*/

    }

}
