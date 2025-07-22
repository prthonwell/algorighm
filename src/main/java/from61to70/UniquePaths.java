package from61to70;

import java.util.Arrays;

class UniquePaths {
    // https://leetcode.cn/problems/unique-paths/ 62
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m - 1], 1);
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m -2; i >= 0; i--) {
            for (int j = n -2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] arr = new int[0]; // 可以创建长度为零的数组
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3,7);
    }
}