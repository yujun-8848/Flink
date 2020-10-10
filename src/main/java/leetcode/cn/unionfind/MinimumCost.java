package leetcode.cn.unionfind;

import leetcode.cn.LD.UnionFind;

import java.util.Arrays;

public class MinimumCost {

    public int minimumCost(int N, int[][] connections) {

        Arrays.sort(connections, (o1, o2) -> o1[2] - o2[2]);
        UnionFind unionFind = new UnionFind(N);
        int ans = 0;
        for (int[] connection : connections) {
            if (!unionFind.isConnect(connection[0], connection[1])) {
                unionFind.unionEle(connection[0], connection[1]);
                ans += connection[2];
            }

        }
        int p = -1;
        for (int i = 0; i < N; i++) {
            int root = unionFind.find(i);

            if (p == -1) {
                p = root;
            } else if (p != root) {
                return -1;
            }
        }
        return ans;
    }
}
