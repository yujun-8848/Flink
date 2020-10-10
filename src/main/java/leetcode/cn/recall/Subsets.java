package leetcode.cn.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 78 子集
 */
public class Subsets {
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        dfs(nums, 0, ans);
        return res;

    }

    public static void dfs(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            //做选择
            list.add(nums[i]);
            //回溯
            dfs(nums, i + 1, list);
            //撤销选择
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);

    }
}
