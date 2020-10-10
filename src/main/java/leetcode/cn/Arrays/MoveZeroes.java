package leetcode.cn.Arrays;

/**
 * 283 移除0
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
