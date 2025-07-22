package leetCode.from51to60;

class maxSubArray {
    // https://leetcode.cn/problems/maximum-subarray/ 53
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        int max = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (dp[i + 1] < 0) dp[i] = nums[i];
            else dp[i] = dp[i + 1] + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
}