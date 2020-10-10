package leetcode.cn.Arrays;

/**
 * 26 删除数组中的重复项
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
