package leetcode.cn.unionfind;


public class NumIslands {

    /**
     * 并查集
     * 最终岛屿的数量就是并查集中连通分量的数目。
     * <p>
     * 把整个grid传入UnionFind计算count
     * 二维矩阵m*n,在一维数组的位置是：（第几行×矩阵宽度）+ 在第几列
     * 历遍grid时，前面已经执行过，不用往回查
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        unionFind.union(i * col + j, (i + 1) * col + j);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        unionFind.union(i * col + j, i * col + j + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    /**
     * 构建二维数组的并查集
     */
    public class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            this.parent = new int[row * col];
            this.count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;

                    }
                }
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
