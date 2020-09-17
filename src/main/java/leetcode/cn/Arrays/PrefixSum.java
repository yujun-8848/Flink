package leetcode.cn.Arrays;

import java.util.Arrays;

/**
 * 前缀数组和
 */
public class PrefixSum {

    private int[] prefixSum;

    public PrefixSum(int[] nums){
        prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i -1];

        }
    }

    public int query(int i,int j){
        return prefixSum[j +1] - prefixSum[i];
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,-2,4,1};
        PrefixSum prefixSum = new PrefixSum(nums);
        System.out.println(Arrays.toString(prefixSum.prefixSum));
        System.out.println(prefixSum.query(1,2));
    }
}
