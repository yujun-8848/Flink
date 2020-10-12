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
        //使用布尔数组used，初始化的时候都为false,表示这些数还没有被选择，当我们选定一个数的时候，
        //就将这个数组的相应位置设置为true，这样在考虑下一个位置的时候，就能够以O(1)的时间复杂度判断
        //这个数是否被选择过，这是一种[以空间换时间]的思想。
        //变量称为状态变量，它们表示了在求解一个问题的时候所处的阶段。需要根据问题的场景设计合适的状态变量。
        boolean[] used = new boolean[nums.length];
        dfs(nums, ans, used);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> ans, boolean[] used) {

        if (nums.length == ans.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                System.out.println("递归前 =>" + ans);
                dfs(nums, ans, used);
                used[i] = false;
                ans.remove(ans.size() - 1);
                System.out.println("递归后 =>" + ans);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
