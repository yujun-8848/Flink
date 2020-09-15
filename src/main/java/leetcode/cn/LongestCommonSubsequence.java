package leetcode.cn;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        String str1 = "babcdefege";
        String str2 = "aczege";
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
