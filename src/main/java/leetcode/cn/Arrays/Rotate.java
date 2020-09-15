package leetcode.cn.Arrays;

import java.util.Arrays;

public class Rotate {

    public static void rotate(int[] nums, int k) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
    }
}
