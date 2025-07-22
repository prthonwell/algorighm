package leetCode.from20to30;

class RemoveElement {
    // 27 https://leetcode.cn/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[index++] = nums[i];
        }
        return index;
    }
}