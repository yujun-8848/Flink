package leetcode.cn.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列
 */
public class Permute {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        dfs(nums, ans);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> ans) {

        if (nums.length == ans.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ans.contains(nums[i])) {
                continue;
            }
            ans.add(nums[i]);
            dfs(nums, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
