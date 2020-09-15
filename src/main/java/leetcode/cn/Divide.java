package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;

        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        //判断两数相除是否为负数
        boolean isNavigate = (dividend ^ divisor) < 0;
        //全部转化为负数是为了防止越界情况
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int res = div(dividend, divisor);
        return isNavigate ? -res : res;
    }

    /**
     * 11 /3
     * 3 <<1  6
     * 11 > 6
     * 6 << 1 12
     * 11 < 12
     * 11 - 6 =5
     * 5  /3
     *
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tempb = b;
        while (tempb << 1 >= a && tempb << 1 < 0) {
            count <<= 1;
            tempb <<= 1;
        }
        return count + div(a - tempb, b);
    }


    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int count = len / 2;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > count) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0, p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, m + n - p1 - p2);
        }


    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }
}
