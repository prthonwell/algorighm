package leetCode.from101to120;

import java.util.Arrays;

class NumDistinct2 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[m], 1);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - m + i; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + (ss[j] == tt[i] ? dp[i + 1][j + 1] : 0);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        NumDistinct2 n = new NumDistinct2();
        System.out.println(n.numDistinct(s, t));
    }
}