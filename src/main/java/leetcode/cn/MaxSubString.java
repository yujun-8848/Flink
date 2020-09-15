package leetcode.cn;

public class MaxSubString {

    public static String maxSubString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }

        String max;
        String min;
        if (str1.length() >= str2.length()) {
            max = str1;
            min = str2;
        } else {
            max = str2;
            min = str1;
        }
        String current;
        for (int i = 0; i < min.length(); i++) {
            for (int start = 0, end = min.length() - i; end <= min.length(); start++, end++) {
                current = min.substring(start, end);
                if (max.contains(current)) {
                    return current;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "abcadefgbcd";
        String str2 = "adefgwgeweg";
        System.out.println(maxSubString(str1, str2));
    }
}
