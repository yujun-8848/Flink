package leetcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 48 最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "abcadefav";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
