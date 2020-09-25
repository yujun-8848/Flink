package leetcode.cn.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56 合并区间
 */
public class Merge {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

    public static void main(String[] args) {
        int[][] res = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] ints : merge(res)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
