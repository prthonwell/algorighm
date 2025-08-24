package huaweiA;

import java.util.*;

public class Ode0095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int n = ss1.length;
        int m = ss2.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (int i = n - 1; i >= 0; i--) {
            if (ss1[i] == '*') {
                dp[i][m] = dp[i + 1][m];
            } else {
                dp[i][m] = false;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (ss1[i] == '?' && IsChar(ss2[j])) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (ss1[i] == '*') {
                    dp[i][j] = dp[i + 1][j];
                    for (int k = j + 1; k <= m; k++) {
                        if (dp[i][j]) break;
                        if (!IsChar(ss2[k - 1])) break;
                        dp[i][j] = dp[i][j] || dp[i + 1][k];
                    }
                } else if (ss1[i] == ss2[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    private static boolean IsChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else return c >= '0' && c <= '9';
    }
}
