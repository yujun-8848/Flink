package leetcode.cn.toOffer;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 二维数组中的查找
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * @createTime 2020年10月23日 09:21:00
 */
public class Offer04 {

    /**
     * 从左下开始搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //注意起始的边界条件
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length;
        int curCol = 0;
        int curRow = row;
        while (curRow >= 0 && curCol < col) {
            if (matrix[curRow][curCol] < target) {
                curCol++;
            } else if (matrix[curRow][curCol] > target) {
                curRow--;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}
                , {10, 13, 14, 17, 24}
                , {18, 21, 23, 26, 30}};

        System.out.println(findNumberIn2DArray(matrix, 5));
    }
}
