public class Palindrome {
    static int reversNumber(int x)
    {
        int reversed_n = 0;
        while (x > 0) {
            reversed_n = reversed_n * 10 + x % 10;
            x = x / 10;
        }
        return reversed_n;
    }

    public static void main(String[] args)
    {
        int x = 12321;
        int reverseN = reversNumber(x);
        System.out.println("Reverse of x = " + reverseN);
        if (x == reverseN)
            System.out.println("Palindrome = Yes");
        else
            System.out.println("Palindrome = No");
    }
}
