package leetcode.cn.Arrays;

import java.util.Arrays;

public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int p1 =0, p2 =0, p = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                res[p] = nums1[p1];
                p++;
                p1++;
                p2++;
            }
        }
        return Arrays.copyOf(res,p);

    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
