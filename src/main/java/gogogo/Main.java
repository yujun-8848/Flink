package gogogo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        String str;
        int[][] dp = new int[m][2 * m + 1];
        for (int r = 0; r < m; r++) {
            str = sc.nextLine();
            String[] s = str.trim().split(" ");
            int top = 0;
            for (int i = m - r; i <= m + r; i++) {
                dp[r][i] = Integer.parseInt(s[top++].trim());
            }
        }
        for (int r = 1; r < m; r++) {
            int left = m - r;
            int right = m + r;
            for (int i = left; i <= right; i++) {
                dp[r][i] += max(dp[r - 1][i - 1], dp[r - 1][i], dp[r - 1][i + 1]);
            }
        }
        int max = 0;
        for (int i = 0; i < 2 * m + 1; i++) {
            max = Math.max(dp[m - 1][i], max);
        }
        System.out.println(max);

    }

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


}

