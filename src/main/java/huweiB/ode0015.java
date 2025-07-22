package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = a[i];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long sum = a[i];
            int l = (i - 1 + n) % n;
            int r = (i + 1 + n) % n;
            if (a[l] > a[r]) l = (l - 1 + n) % n;
            else r = (r + 1 + n) % n;
            sum += dfs(l, r, dp, a);
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

    private static long dfs(int l, int r, long[][] dp, long[] a) {
        if (dp[l][r] != 0) return dp[l][r];
        int nl = l, nr = r, n = a.length;
        long sum1 = a[nl];
        nl = (nl - 1 + n) % n;
        if (a[nl] > a[nr]) nl = (nl - 1 + n) % n;
        else nr = (nr + 1 + n) % n;
        sum1 += dfs(nl, nr, dp, a);

        nl = l; nr = r;
        long sum2 = a[nr];
        nr = (nr + 1 + n) % n;
        if (a[nl] > a[nr]) nl = (nl - 1 + n) % n;
        else nr = (nr + 1 + n) % n;
        sum2 += dfs(nl, nr, dp, a);

        long res = Math.max(sum1, sum2);
        dp[l][r] = res;
        return res;
    }

}
