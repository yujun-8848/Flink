package leetcode.cn.recall;


import java.util.ArrayList;
import java.util.List;

/**
 * 39 组合总和
 *
 *
 */
public class CombinationSum {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> ans = new ArrayList<>();
        dfs(candidates, 0, target, ans);
        return res;

    }

    public static void dfs(int[] candidates, int begin, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        //用于对组合进行去重操作
        for (int i = begin; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));
    }
}
