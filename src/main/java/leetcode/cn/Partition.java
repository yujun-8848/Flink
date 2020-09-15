package leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> partition = partition(s);
        for (List<String> stringList : partition) {
            System.out.println(stringList);
        }
    }

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<String> stack = new ArrayList<>();
        dfs(s, stack, res);
        return res;
    }

    public static void dfs(String s, List<String> stack, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (!check(s.substring(0, i))) {
                continue;
            }
            stack.add(s.substring(0, i));
            dfs(s.substring(i), stack, res);
            stack.remove(stack.size() -1);
        }
    }

    public static boolean check(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
