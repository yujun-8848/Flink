package leetcode.cn.toOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 数组中重复的数字
 * @Description 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * @createTime 2020年10月23日 08:33:00
 */
public class Offer03 {

    //超出时间限制
    public static int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //执行用时：
    //10 ms, 在所有 Java 提交中击败了15.32%的用户
    public static int findRepeatNumber2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                return num;
            }

        }
        return -1;
    }

    //set方便查找重复数字
    public static int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 由于所有数字都在长度为n的数组中，则若存在重复数字，则必定有同一数字对应不同索引
     * 这里使用原地交换的算法，将索引与值进行一一对应，对应不上则为所求的重复数字
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber4(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }
}
