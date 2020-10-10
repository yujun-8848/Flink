package leetcode.cn.unionfind;

public class FindCircleNum {

    private static int count = 0;

    public static int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        count = M.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    union(i, j, parent);
                }

            }
        }
        return count;

    }

    public static int find(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public static void union(int p, int q, int[] parent) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }


}
