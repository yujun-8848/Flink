package leetcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * "abcde","ac"
 * 3
 * 给定字符串str1和str2，求str1的字符串中含有dtr2所有字符的最小字符串长度，不存在则输出0
 */
public class MinLength {

    //使用通用的滑动窗口解决该问题
    //对于2个字符串之间的操作，均可以考虑使用此框架进行编写
    public static int minWindow(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : str2.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < str1.length()) {
            char c = str1.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                minLen = Math.min(minLen, right - left);
                char d = str1.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 最长不重复子串
     * @param s
     * @return
     */
    public static int minWindow3(String s) {
        Map<Character, Integer> needs = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLen = 0;
        while (right < s.length() ) {
            char c = s.charAt(right);
            right++;
            needs.put(c, needs.getOrDefault(c, 0) + 1);
            while (needs.get(c) >1){
                char d = s.charAt(left);
                left++;
                needs.put(d,needs.getOrDefault(d,0) -1);
            }
            minLen = Math.max(minLen,right -left);
        }
        return minLen;

    }

    /**
     * 字符串排列
     * @param str1
     * @param str2
     * @return
     */
    public static boolean minWindow2(String str1, String str2) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : str1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < str2.length()) {
            char c = str2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            while (right - left >= str1.length()) {
                if (valid == needs.size()) {
                    return true;
                }
                char d = str2.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (windows.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    public int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i != chars2.length; i++) {
            map[chars2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = chars2.length;
        int minLen = Integer.MAX_VALUE;
        while (right != chars1.length) {
            map[chars1[right]]--;
            if (map[chars1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chars1[left]] < 0) {
                    map[chars1[left++]]++;
                }
                minLen = Math.min(minLen, right - left + 1);
                match++;
                map[chars1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcde", "ac"));
        System.out.println(minWindow2("ab", "eidbaoo"));
        System.out.println(minWindow3("abcadefav"));
    }
}
