package leetcode.cn.Intervals;

import java.util.Arrays;

/**
 * 1288 删除被覆盖区间
 * <p>
 * 对于区间合并的问题，就是线段问题，让你合并所有线段，找到线段的交集，一般会有两种方案：
 * 1.排序。常见的排序方法就是按照区间起点排序，或者按照起点升序排序，若起点相同，则按照
 * 终点降序排序。当然，如果你非要按照终点排序，无非对称操作，本质是一样的。
 * 2.画图分析各种情况。
 */
public class RremoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {

        //按起点升序，终点降序进行排序
        Arrays.sort(intervals, (o1, o2) ->
        {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        //定位起点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //区间覆盖
            if (right >= interval[1] && left<= interval[0]) {
                res++;
            }
            //区间相交,合并
            if (interval[1] > right && interval[0] < right) {
                right = interval[1];
            }
            //区间不相交，更新起点，终点
            if (interval[0] > right) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length -res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}, {2, 7}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
