package leetcode.cn.toOffer;

/**
 * Given a m*n grid, a start position (x0, y0), a target position (x1, y1).
 * Some grids are walkable (1) and other grids are obstacles (0). You control
 * a robot which can move in {up, down, left, right} 4 directions on walkable
 * grids. You need to output the length of shortest path to move the robot
 * from start position to target position.
 */
public class Offer面试 {

    private static int min = Integer.MIN_VALUE;
    private static int x1 = 3;
    private static int y1 = 2;

    public static void main(String[] args) {

        char[][] grid = {{'0', '0', '0','0'},
                {'1', '0', '0','0'},
                {'1', '1', '0','0'}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, 0, 0, visited, 0);
        System.out.println(min);

    }

    public static void dfs(char[][] grid, int i, int j, boolean[][] visited, int step) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]
                || grid[i][j] == '1') {
            return;
        }
        visited[i][j] = true;
        if (step > min && min!= Integer.MIN_VALUE) {
            visited[i][j] = false;
            return;
        }
        if (i == x1 && j == y1) {
            min = step;
            visited[i][j] = false;
            return;
        }
        dfs(grid, i + 1, j, visited, step + 1);
        dfs(grid, i - 1, j, visited, step + 1);
        dfs(grid, i, j - 1, visited, step + 1);
        dfs(grid, i, j + 1, visited, step + 1);
    }


}
