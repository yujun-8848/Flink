package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class UnionFind2 {

    private int size;
    private Map<Integer, Integer> parent;

    public UnionFind2(int[] arr) {
        this.size = arr.length;
        parent = new HashMap<>();
        for (int num : arr) {
            parent.put(num, num);
        }
    }

    public boolean isConnect(int ele1, int ele2) {
        return find(ele1) == find(ele2);
    }

    public void unionEle(int ele1, int ele2) {
        if (!isConnect(ele1, ele2)) {
            int one = find(ele1);
            int two = find(ele2);
            parent.put(one, two);
        }
    }

    public int find(int num) {
        int root = num;
        while (root != parent.get(root)) {
            root = parent.get(root);
        }
        while (num != parent.get(num)) {
            int cur = num;
            num = parent.get(num);
            parent.put(cur, root);
        }
        return root;

    }
}
