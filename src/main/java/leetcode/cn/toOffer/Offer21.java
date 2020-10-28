package leetcode.cn.toOffer;

import java.util.Arrays;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 调整数组顺序，使奇数位于偶数之前
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @createTime 2020年10月28日 08:49:00
 */
public class Offer21 {
    //双指针
    public static int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1,temp;
        while (i < j){
            while (i < j && (nums[i] & 1) == 1){
                i++;
            }
            while (i <j && (nums[j] & 1) == 0){
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
