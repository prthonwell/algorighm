package from51to60;

class CanJump {
    // https://leetcode.cn/problems/jump-game/ 55
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return true;
        int n = nums.length;
        int index = 0;
        int cur = nums[0];
        while (cur > 0) {
            int max = index + cur;
            int R = index + cur;
            for (int i = index; i <= R && i < n; i++) {
                int len = i + nums[i];
                if (len > max) {
                    max = len;
                    index = i;
                    cur = nums[i];
                }
            }
            if (max >= n - 1) {
                return true;
            }
            if (max == R) {
                return false;
            }
        }
        return false;
    }
}