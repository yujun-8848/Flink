package leetcode.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Partition {

    public static void main(String[] args) {
        String s = "aab";
        for (List<String> list : partition(s)) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        dfs(s, res, stack);
        return res;

    }

    public static void dfs(String s, List<List<String>> res, Stack<String> stack) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            if (!isOk(s.substring(0, i))) {
                continue;
            }
            stack.add(s.substring(0, i));
            dfs(s.substring(i), res, stack);
            stack.remove(stack.size() - 1);
        }

    }

    /**
     * 是否是回文串
     *
     * @param s
     * @return
     */
    public static boolean isOk(String s) {
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
