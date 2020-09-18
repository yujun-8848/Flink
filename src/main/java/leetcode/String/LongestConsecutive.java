package leetcode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LongestConsecutive {

    static int count = 0;

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int curNum;
        int count;
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                curNum = num;
                count = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    count++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }

    public static int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> parent = new HashMap<>();
        count = nums.length;
        for (int num : nums) {
            parent.put(num, num);
        }
        int max = 1;
        for (int num : nums) {
            union(num, num + 1, parent);
        }
        for (int num : nums) {
            max = Math.max(max, find(num, parent) - num + 1);
        }
        return max;
    }

    public static Integer find(int p, Map<Integer, Integer> parent) {
        if (!parent.containsKey(p)) {
            return null;
        }
        while (p != parent.get(p)) {
            p = parent.get(p);
        }
        return p;
    }

    public static void union(int p, int q, Map<Integer, Integer> parent) {
        Integer rootP = find(p, parent);
        Integer rootQ = find(q, parent);
        if (rootP.equals(rootQ)) {
            return;
        }
        if (rootP == null || rootQ == null) {
            return;
        }
        parent.put(rootP, rootQ);
        count--;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive2(nums));
    }
}
