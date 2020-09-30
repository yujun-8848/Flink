package leetcode.cn.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度O(n2),空间复杂度O(1)
 */
public class InsertSort {

    public static int[] insertSort(int[] nums) {
        int len = nums.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            current = nums[i];
            preIndex = i - 1;
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 6, 1, 0, 5};
        System.out.println(Arrays.toString(insertSort(nums)));
    }
}
