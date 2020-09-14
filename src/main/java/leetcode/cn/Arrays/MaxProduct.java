package leetcode.cn.Arrays;

public class MaxProduct {

    //最大子序列
    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int[] dp2 = new int[nums.length + 1];
        dp2[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], Math.max(dp[i - 1], dp2[i - 1] * nums[i]));
            dp2[i] = Math.min(nums[i], Math.min(dp[i - 1], dp2[i - 1] * nums[i]));
            max = Math.max(dp[i], max);
        }
        return max;

    }

    public static int maxProduct2(int[] nums) {

        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(num * imax, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4,-2};
        System.out.println(maxProduct2(nums));
    }
}
