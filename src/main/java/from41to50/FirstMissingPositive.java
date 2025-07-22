package from41to50;

class FirstMissingPositive {
    // https://leetcode.cn/problems/first-missing-positive/ 41困难
    public int firstMissingPositive(int[] nums) {
        // 减少空间使用的方法，原地表操作，直接用给定的表来记录结果
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) continue;
            if (nums[i] <= i + 1) {
                nums[nums[i] - 1] = nums[i];
            } else {
                if (nums[i] == nums[nums[i] - 1]) {
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}