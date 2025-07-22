package from121to140;

class SingleNumber {
    // https://leetcode.cn/problems/single-number-ii/ 137
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            if (sum % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}