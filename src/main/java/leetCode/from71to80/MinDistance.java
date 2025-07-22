package leetCode.from71to80;

class MinDistance {
    // https://leetcode.cn/problems/edit-distance/ 72
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
//        if (n < m) {
//            String temp = word1;
//            word1 = word2;
//            word2 = temp;
//            n = word1.length();
//            m = word2.length();
//        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[m][i] = n - i;
        }
        for (int j = 0; j < m; j++) {
            dp[j][n] = m - j;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (chars1[j] == chars2[i]) {
                    dp[i][j] = dp[i + 1][j + 1];
                }else {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("ity", "ties"));
    }
}