package huaweiB;

import java.math.BigInteger;
import java.util.*;

public class odb0046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        BigInteger[][] dp = new BigInteger[M - 6][2];
        dp[M - 7][0] = BigInteger.valueOf(1);
        dp[M - 7][1] = BigInteger.valueOf(0);
        for (int i = M - 8; i >= 0; i--) {
            dp[i][0] = dp[i + 1][1];
            dp[i][1] = dp[i + 1][0];
            if (i + 2 < M - 6) {
                dp[i][0] = dp[i][0].add(dp[i + 2][1]);
                dp[i][1] = dp[i][1].add(dp[i + 2][0]);
            }
        }
        System.out.println(dp[0][1]);
        sc.close();
    }
}
