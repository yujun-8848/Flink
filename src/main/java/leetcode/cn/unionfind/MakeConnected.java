package leetcode.cn.unionfind;

public class MakeConnected {
    private static int count = 0;

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        count = n;
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] connection : connections) {
            union(connection[0], connection[1], parent);
        }
        return count - 1;
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
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(6,connections));
    }
}
