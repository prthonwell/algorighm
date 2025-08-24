package leetCode.from201to300;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        for (int i = 0; i < n + 1; i++) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{1, 2, 3, 4}));
    }
}
