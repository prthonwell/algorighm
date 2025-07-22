package leetCode.from20to30;

public class RemoveDuplicates {
    // 26
    public int removeDuplicates(int[] nums) {
        int val = nums[0];
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[index++] = nums[i];
            val = nums[i];
        }
        return index;
    }
}