package leetcode.cn.LD;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class LD53 {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = (dp[i - 1] + nums[i]);
            }
        }
        for (int i : dp) {
            res = Math.max(i,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(LD53.maxSubArray(nums));
    }

}
