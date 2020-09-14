package leetcode.cn.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    /**
     * 最长连续子序列
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = Integer.MIN_VALUE;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while (set.contains(currNum + 1)) {
                    currLen++;
                    currNum++;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

}
