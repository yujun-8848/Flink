package leetcode.cn.dp;


import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1,3,5,3,67,0};
        System.out.println(lengthOfLIS(nums));
    }
}
