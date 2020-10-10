package leetcode.cn.unionfind;

import leetcode.cn.LD.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LD5513_union {

    public static int minCostConnectPoints(int[][] points) {

        UnionFind unionFind = new UnionFind(points.length);
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (len != 0) {
                    res.add(new Edge(len, i, j));
                }

            }
        }
        Collections.sort(res);
        int ans = 0;
        for (Edge edge : res) {
            int i = edge.getU();
            int j = edge.getV();
            int len = edge.getLen();
            if (unionFind.find(i) == unionFind.find(j)) {
                continue;
            }
            ans += len;
            unionFind.unionEle(i, j);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }
}

class Edge implements Comparable<Edge> {
    private int len;
    private int u;
    private int v;

    public Edge(int len, int u, int v) {
        this.len = len;
        this.u = u;
        this.v = v;
    }

    public int getLen() {
        return len;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    @Override
    public int compareTo(Edge o) {
        return this.len - o.len;
    }


}

