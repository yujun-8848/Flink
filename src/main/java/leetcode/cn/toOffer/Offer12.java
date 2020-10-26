package leetcode.cn.toOffer;

/**
 * @author yujun
 * @version 1.0.0
 * @ClassName 矩阵中的路径
 * @Description 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * @createTime 2020年10月26日 09:02:00
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //边界条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';

        int[][] w = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] ints : w) {
            int i1 = i + ints[0];
            int j1 = j + ints[1];
            if (dfs(board, word, i1, j1, k + 1)) {
                return true;
            }
        }
        //按照上下左右的方向进行搜索
//        boolean res = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
//                || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = temp;
//        return res;
        return false;
    }

    public static void main(String[] args) {
        //["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Offer12 offer12 = new Offer12();
        System.out.println(offer12.exist(board, "ABCCED"));

    }
}