package leetcode.cn.LD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static List<List<Integer>> twoSum(int[] nums, int strat, int target) {
        Arrays.sort(nums);
        int lo = strat, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[lo]);
                list.add(nums[hi]);
                res.add(list);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<List<Integer>> lists = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                res.add(list);
            }
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 7, 4, 6, 6, 6};
        System.out.println(twoSum(nums, 0, 8).toString());
        int[] num = {1, 1, 1, 4, 5, 6, 2, 2, 2, 5, 5};
        System.out.println(threeSum(num, 6));

    }
}
