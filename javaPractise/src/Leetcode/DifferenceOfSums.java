package Leetcode;

public class DifferenceOfSums {
    public static void main(String[] args) {
        DifferenceOfSums differenceOfSums = new DifferenceOfSums();
        System.out.println(differenceOfSums.sollution(5,1));
    }
    public int sollution(int n, int m) {
        int num1 = 0, num2 = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0){
                num1 += i;
            } else {
                num2 += i;
            }
        }
        return num2 - num1;
    }
}
