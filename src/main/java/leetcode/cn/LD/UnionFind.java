package leetcode.cn.LD;

/**
 * 并查集
 */
public class UnionFind {

    private int[] parent;
    private int count;
    private int[] size;

    public UnionFind(int M) {
        parent = new int[M];
        size = new int[M];
        count = M;
        for (int i = 0; i < M; i++) {
            parent[i] = i;
            size[i] = i;
        }
    }

    public int find(int ele) {
        while (ele != parent[ele]) {
            parent[ele] = parent[parent[ele]];
            ele = parent[ele];
        }
        return ele;
    }

    public void unionEle(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean isConnect(int p ,int q){
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

}
