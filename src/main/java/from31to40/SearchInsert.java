package from31to40;

import static java.util.Arrays.binarySearch;

class SearchInsert {
    // https://leetcode.cn/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int end = nums.length - 1;
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        if (nums[start] > target) {
            return start;
        } else return end;
    }
}