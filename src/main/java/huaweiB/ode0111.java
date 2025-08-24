package huaweiB;

import java.util.*;

public class ode0111 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort( a );
        int[][] dp = new int[n + 1][2]; // 0 组数， 1 总差距
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            if (a[i - 1] - a[i - 2] <= m) {
                int group = dp[i - 2][0] + 1;
                int dif = dp[i - 2][1] + a[i - 1] - a[i - 2];
                if (group > dp[i][0] || (group == dp[i][0] && dif < dp[i][1])) {
                    dp[i][0] = group;
                    dp[i][1] = dif;
                }
            }
        }
        if (dp[n][0] == 0) {
            System.out.println(-1);
        }else {
            System.out.println(dp[n][1]);
        }
        sc.close();
    }
}
