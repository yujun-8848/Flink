package leetcode.cn.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 组合
 */
public class Combine {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {

        List<Integer> ans = new ArrayList<>();
        dfs(n, k, 1, ans);
        return res;
    }

    private static void dfs(int n, int k, int start, List<Integer> ans) {

        if (k == ans.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            dfs(n, k, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
