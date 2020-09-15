package leetcode.cn;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums = {1,-1,2,5};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive (int[] nums) {
       int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <=0){
                nums[i] = n +1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n){
                nums[num -1] = -Math.abs(nums[num -1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] >0){
                return  i +1;
            }
        }
        return n +1;
    }
}
