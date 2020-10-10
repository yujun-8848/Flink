package leetcode.cn.unionfind;

import leetcode.cn.LD.UnionFind;

import java.util.Arrays;

/**
 * 130 被环绕的区域
 * <p>
 * 二维数组向一维数组的映射关系：(x,y) => x * n + y  n为列数
 */
public class Solve {

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        UnionFind uf = new UnionFind(m * n + 1);
        //头队长与边界进行联通
        int dumpy = m * n;
        //首列与尾列
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'o') {
                uf.unionEle(i * n, dumpy);
            }
            if (board[i][n - 1] == 'o') {
                uf.unionEle(i * n + (n - 1), dumpy);
            }
        }
        //首行与尾行
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'o') {
                uf.unionEle(i, dumpy);
            }
            if (board[m - 1][i] == 'o') {
                uf.unionEle((m - 1) * n + i, dumpy);
            }
        }
        //方向数组，用于遍历4个方向
        int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'o') {
                            uf.unionEle(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        //所有不与dumpy的o均被替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.isConnect(i * n + j, dumpy)) {
                    board[i][j] = 'x';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'x', 'x', 'x', 'x', 'o'},
                {'x', 'x', 'x', 'o', 'x'},
                {'o', 'o', 'x', 'o', 'x'},
                {'x', 'o', 'x', 'x', 'x'}};
        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
