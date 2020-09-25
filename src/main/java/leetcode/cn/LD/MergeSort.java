package leetcode.cn.LD;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 21, 8, 2, 3, 0, 5, 5};
        int[] temp = new int[arr.length];
        merge(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(arr, left, mid, temp);
            merge(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= right) {
            temp[p++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[p++] = arr[p2++];
        }
        int t = 0;

        //从left开始
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
