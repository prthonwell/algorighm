package from41to50;

class Jump {
    // https://leetcode.cn/problems/jump-game-ii/ 45
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        for (int i = n - 2; i >= 0; i--) {
            int cur = nums[i];
            if (cur + i == n - 1) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + cur && j < n; j++) {
                if (dp[j] < min) min = dp[j];
            }
            dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
        }
        return dp[0];
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int times = 0;
        int right = 0;
        while (right < n - 1) {
            int area = nums[right] + right;
            if (area >= n - 1) {
                times++;
                break;
            }
            int length = 0;
            for (int i = right + 1; i <= area && i < n; i++) {
                if (nums[i] + i >= length) {
                    length = nums[i] + i;
                    right = i;
                }
            }
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Jump().jump2(nums));
    }
}