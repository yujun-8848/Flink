package leetcode.cn.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986 区间列表的交集
 */
public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || B == null){
            return new int[0][0];
        }

        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (a2 < b2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ints = intervalIntersection(A, B);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
