package leetcode.cn.unionfind;

import leetcode.cn.LD.UnionFind;

import java.util.Arrays;

public class FindRedundantConnection {

    private static int count = 0;

    public static int[] findRedundantConnection2(int[][] edges) {
        int m = edges.length;
        UnionFind unionFind = new UnionFind(m + 1);
        for (int[] edge : edges) {
            if (unionFind.isConnect(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
            unionFind.unionEle(edge[0], edge[1]);
        }
        return null;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        count = edges.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, res);
        }
        return res;


    }

    public static int find(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public static void union(int p, int q, int[] parent, int[] res) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;

        }else {
            res[0] = p;
            res[1] = q;
        }
        count--;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
        System.out.println(count);
    }
}
