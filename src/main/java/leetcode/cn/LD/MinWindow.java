package leetcode.cn.LD;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static int minWindow(String str1, String str2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : str2.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        while (right < str1.length()) {
            char c = str1.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = Math.min(minLen,right - left);
                }
                char d = str1.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (needs.get(d).equals(windows.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        //return minLen == Integer.MAX_VALUE ? "" : str1.substring(start, right);
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        String str1 = "ebbancf";
        String str2 = "abc";
        System.out.println(minWindow(str1, str2));
        String s1 = "abcde";
        String s2 = "ac";
        System.out.println(minWindow(s1,s2));
    }
}
