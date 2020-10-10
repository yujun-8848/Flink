package leetcode.cn.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 131 分割回文串
 */
public class Partition {

    private static List<List<String>> res = new ArrayList<>();
    private static int len;

    public static List<List<String>> partition(String s) {

        List<String> ans = new ArrayList<>();
        len = s.length();
        dfs(s, 0, ans);
        return res;
    }

    private static void dfs(String s, int start, List<String> ans) {
        if (start == len) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!checkPalindrome(s, start, i)) {
                return;
            }
            ans.add(s.substring(start, i + 1));
            dfs(s, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }

    private static boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

}
