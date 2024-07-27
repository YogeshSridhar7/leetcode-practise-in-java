package Leetcode;

public class ConcatArray {
    public static void main(String[] args) {
        ConcatArray concatArray = new ConcatArray();
        int[] myNums= {1,2,3,1};
        int[] result = concatArray.getConcatenation(myNums);
        System.out.println(result);
        for ( int i:result){
            System.out.println(i + " ");
        }
    }

    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];
        for (int i = 0; i<len; i++){
            ans[i] = nums[i];
            ans[i+len] = nums[i];
        }
        return ans;
    }
}
