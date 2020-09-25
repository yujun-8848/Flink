package leetcode.cn.LD;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class LD139 {
    /**
     * 3 *(a +b + c) - (a + a +a + b + b +b +c) = 2c
     *
     * @param nums
     * @return
     */

    public static int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        long numsSum = 0;
        long arraySum = 0;
        for (int num : nums) {
            numsSum += num;
            set.add(num);
        }
        for (Integer aLong : set) {
            arraySum += aLong;
        }
        return (int)((arraySum * 3 - numsSum) / 2);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(LD139.singleNumber(nums));
    }
}
