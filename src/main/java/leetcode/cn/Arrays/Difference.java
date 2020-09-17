package leetcode.cn.Arrays;

import java.util.Arrays;

/**
 * 差分数组
 */
public class Difference {

    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间[i,j]增加val（可以是负数）
     *
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        //根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,6,3,1};
        Difference difference = new Difference(nums);
        System.out.println(Arrays.toString(difference.diff));
        difference.increment(1,3,3);
        int[] result = difference.result();
        System.out.println(Arrays.toString(result));
    }
}
