package leetcode.cn.unionfind;

import java.util.ArrayList;
import java.util.List;

public class NumIslands2 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m, n, positions);

        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            unionFind.union(position[0] ,position[1]);
            res.add(unionFind.getCount());
        }
        return res;

    }

    class UnionFind{
        private  int[] parent;
        private int count;

        public UnionFind(int m,int n,int[][] positions) {
            this.parent = new int[m * n];
            this.count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    parent[i * n + j] = i * n + j;
                }
            }
        }

        public  int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p ,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
