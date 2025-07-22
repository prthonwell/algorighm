package from121to140;

class MinCut {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
        int[] resDp = new int[n];
        resDp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (dp[i][j] == 1) {
                    if (j + 1 < n) {
                        min = Math.min(min, resDp[j + 1] + 1);
                        continue;
                    }
                    min = 1;
                    break;
                }
            }
            resDp[i] = min;
        }
        return resDp[0] - 1;
    }
    public static void main(String[] args) {
        MinCut m = new MinCut();
        System.out.println(m.minCut("bb"));
    }
}