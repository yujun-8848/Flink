package leetcode;


import java.util.*;

public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 4, 5};
        int[] new_copy = new int[3];
        System.arraycopy(arr1, 0, new_copy, 0, 3);
        int[] arr2 = {6, 5, 4};
        int[] ints = arrayMerge(arr1, 4, arr2, 3);
        System.out.println(Arrays.toString(ints));
        System.out.println(combination(3, 2));
        System.out.println(Arrays.toString(new_copy));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while ((p1 < m) && (p2 < n)) {
            res[p++] = (nums1[p1] < nums2[p2]) ? nums1[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            res[p++] = nums1[p1++];
        }
        if (p2 < n) {
            res[p++] = nums2[p2++];
        }
    }

    public static int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        int[] res = new int[n + m];
        int p = 0;
        int p1 = 0;
        int p2 = m - 1;
        while ((p1 < n) && (p2 >= 0)) {
            res[p++] = (array1[p1] < array2[p2]) ? array1[p1++] : array2[p2--];
        }
        if (p1 < n) {
            res[p++] = array1[p1++];
        }
        if (p2 >= 0) {
            res[p++] = array2[p2--];
        }
        return res;
    }

    public static int combination(int m, int n) {

        String key = m + "," + n;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return m;
        }
        if (n > m / 2) {
            return combination(m, m - n);
        }
        if (n > 1) {
            if (!map.containsKey(key)) {
                return map.put(key, combination(m - 1, n - 1) + combination(m - 1, n));
            }
            return map.get(key);
        }
        return -1;

    }
}
