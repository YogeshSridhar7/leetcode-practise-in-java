package Leetcode;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.solution(430));
    }

    public int solution(int num) {

        while(num/10 != 0) {
            int sum =0;

            while (num>0) {
                int rem = num%10;
                sum += rem;
                num /= 10;
            }

            if(sum/10==0){
                return sum;
            } else {
                num = sum;
            }
        }
        return num;
    }
}
