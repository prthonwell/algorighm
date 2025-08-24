package huaweiA;

import java.util.*;

public class Ode0079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int m = ss[0].length();
        int n = ss[1].length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; i++) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                if (ss[0].charAt(j) == ss[1].charAt(i)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1] + 1);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
