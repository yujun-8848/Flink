package leetcode.String;

/**
 * "abcde","ac"
 * 3
 * 给定字符串str1和str2，求str1的字符串中含有dtr2所有字符的最小字符串长度，不存在则输出0
 */
public class MinLength {

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
        MinLength minLength = new MinLength();
        System.out.println(minLength.minLength("abcde", "ac"));
    }
}
