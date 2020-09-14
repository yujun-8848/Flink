package leetcode.cn.Arrays;

import java.util.Arrays;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 3) {
            return false;
        }
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {

            if (num > secondMin) {
                return true;
            }
            if (num <= firstMin) {
                firstMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            }
        }
        return false;
    }
}
