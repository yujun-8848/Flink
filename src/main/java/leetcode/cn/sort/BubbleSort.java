package leetcode.cn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度O(n2),空间复杂度O(1)
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums  ={2,3,2,6,1,0,5};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }


}
