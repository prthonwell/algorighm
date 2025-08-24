package leetCode.from41to50;

class IsMatch {
    // https://leetcode.cn/problems/wildcard-matching/ 44
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m - 1; i >= 0; i--) {
            if (p.charAt(i) == '*' && dp[i + 1][n]) {
                dp[i][n] = true;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = p.charAt(i);
                if (c == '*') {
                    if (dp[i + 1][j] || dp[i + 1][j + 1] || dp[i][j + 1]) {
                        dp[i][j] = true;
                    }
                } else if (c == '?') {
                    if (dp[i + 1][j + 1]) dp[i][j] = true;
                } else {
                    if (c == s.charAt(j) && dp[i + 1][j + 1]) dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}