package Leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(10,3));
    }
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend < 0) == (divisor < 0);

        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        int result = 0;

        while (dividend1 >= divisor1) {
            int count = 0;
            while (dividend1 >= (divisor1 << (count + 1))) {
                count++;
            }
            result += 1 << count;
            dividend1 -= divisor1 << count;
        }

        return sign ? result : -result;
    }
}
