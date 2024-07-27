package Leetcode;

public class PascalTriangle {
    public int factorial(int i){
        if( i==0){
            return 1;
        }
        return i*factorial(i-1);
    }

    public static void main(String[] args) {
        int n = 5, i, j;
        PascalTriangle p = new PascalTriangle();
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= n - i; j++) {
                // for left spacing
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                // nCr formula
                System.out.print(
                        " "
                                + p.factorial(i)
                                / (p.factorial(i - j)
                                * p.factorial(j)));
            }
            // for newline
            System.out.println();
        }
    }
}
