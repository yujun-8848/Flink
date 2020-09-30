package leetcode.cn.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n2),空间复杂度O(1)
 */
public class SelectSort {

    public static int[] selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            //最小索引
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 6, 1, 0, 5};
        System.out.println(Arrays.toString(selectSort(nums)));
    }
}
