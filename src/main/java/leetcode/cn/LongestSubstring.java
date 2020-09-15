package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int longestSubstring(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder builder = new StringBuilder(s);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(s.charAt(i)) < k) {
                builder.setCharAt(i, ' ');
            }
        }
        String[] s1 = builder.toString().split(" ");
        if (s1.length == 1) {
            return s1[0].length();
        }

        int max = 0;
        for (String s2 : s1) {
            max = Math.max(max, longestSubstring(s, k));
        }
        return max;
    }

    public static int longestSubstring2(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        boolean full = true;
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] < k) {
                full = false;
            }
        }
        if (full) {
            return s.length();
        }
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            if (res[s.charAt(right) - 'a'] < k) {
                max = Math.max(longestSubstring2(s.substring(left, right), k), max);
                left = right + 1;
            }
            right++;
        }
        max = Math.max(max, longestSubstring2(s.substring(left), k));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring2("abaabcde", 2));
    }
}
