package leetcode.cn.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合2： 数字只能使用一次
 */
public class CombinationSum2 {
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
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

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            //因为元素不能重复，递归下去使用i + 1,而不是i
            dfs(candidates, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {3,8,6};
        System.out.println(combinationSum2(nums, 14));
    }
}
