package leetcode.cn.Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(containsDuplicate(nums));
    }
}
