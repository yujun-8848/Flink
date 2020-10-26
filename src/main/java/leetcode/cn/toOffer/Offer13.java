package leetcode.cn.toOffer;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 机器人的运动范围
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * @createTime 2020年10月26日 09:54:00
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visit);
    }

    public int dfs(int m, int n, int i, int j, int k, boolean[][] visit) {
        if (i >= m || j >= n || bitSum(i) + bitSum(j) > k || visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        return 1 + dfs(m, n, i + 1, j, k, visit) + dfs(m, n, i, j + 1, k, visit);
    }

    //计算位数之和
    public static int bitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(bitSum(35));
    }
}
