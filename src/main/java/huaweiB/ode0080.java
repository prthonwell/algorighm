package huaweiB;

import java.util.*;

public class ode0080 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();

        // 滚动数组
        int[] dp = new int[1000000];

        while (n-- > 0) {
            int time = sc.nextInt();
            int value = sc.nextInt();

            // 背包问题
            for (int i = t; i >= 0; i--) {
                if (i >= time) {
                    dp[i] = Math.max(dp[i], dp[i - time] + value);
                } else {
                    break;
                }
            }
        }

        System.out.println(dp[t]);
        sc.close();
    }
}
