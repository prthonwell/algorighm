package from101to120;

import java.util.List;

class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp = triangle.get(n - 1).stream().mapToInt(i -> i).toArray();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}