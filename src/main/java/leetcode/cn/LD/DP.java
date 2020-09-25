package leetcode.cn.LD;

/**
 * 动态规划：
 * 题型
 * 1.计数
 * 2.求最大最小值
 * 3.存在性
 */
public class DP {
    /**
     * int[] nums = {1,2,4,1,7,8,3}
     * 从数组中选择不相邻的最大数之和
     * 动态规划问题：选与不选：{
     * 选 -> dp[i -2] + nums[i]
     * 不选 -> dp[i -1]
     * dp[i]表示到i的最优解(最大和)
     * }
     *
     * @param nums
     * @return
     */
    public static int searchMax(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }
        return dp[nums.length - 1];
    }

    /**
     * 动态规划
     * 状态转移：
     * 1.状态：dp[i][S] = 前i个数和为S
     * 选择 i -> dp[i -1][S - nums[i]]
     * 不选 i -> dp[i -1][s]
     * 边界条件：S =0，Ture;
     * S < 0,False;
     *
     * @param nums
     * @param S
     * @return
     */
    public static boolean twoSum(int[] nums, int S) {
        boolean[][] dp = new boolean[nums.length][S + 1];
        for (int i = 0; i < S + 1; i++) {
            dp[0][i] = false;
        }
        if (S >= nums[0]) {
            dp[0][nums[0]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < S + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][S];

    }

    /**
     * 使用面值为2,5,7的硬币，用最少的硬币拼出目标值
     * 1.选择 -> dp[M- 2] + 1,dp[M- 5] +1,dp[M -7] +1;
     * 2.状态 -> dp[i] 拼出i所需要的最小硬币数。
     *
     * @param A
     * @param M
     * @return
     */
    public static int coinChange(int[] A, int M) {

        int[] dp = new int[M + 1];
        int n = A.length;
        dp[0] = 0;
        for (int i = 0; i < M; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i >= A[j] && dp[i - A[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i - A[j]] + 1);
                }

            }
        }
        if(dp[M] == Integer.MAX_VALUE){
            dp[M] = -1;
        }
        return dp[M];
    }

    /**
     * 可行性
     * 青蛙跳石头
     *
     * @param A
     * @return
     */
    public static boolean canJump(int[] A){
        int n = A.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if(dp[j] && j + A[j] >=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n -1];

    }

    public static void main(String[] args) {
        System.out.println(DP.searchMax(new int[]{1, 2, 4, 1, 7, 8, 3}));
        System.out.println(twoSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(twoSum(new int[]{3, 34, 4, 12, 5, 2}, 10));
        System.out.println(twoSum(new int[]{3, 34, 4, 12, 5, 2}, 11));
        System.out.println(twoSum(new int[]{3, 34, 4, 12, 5, 2}, 12));
        System.out.println(twoSum(new int[]{3, 34, 4, 12, 5, 2}, 13));
        System.out.println(canJump(new int[]{2,3,1,1,4}));

    }
}
