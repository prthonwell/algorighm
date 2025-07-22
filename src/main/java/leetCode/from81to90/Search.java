package leetCode.from81to90;

class Search {
    // https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/ 81
    public boolean search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            boolean flag; // false表示mid在右，true表示mid在左
            int midV = nums[mid];
            if (nums[mid] == target) {
                return true;
            }
            if (midV > nums[L]) {
                flag = false;
            } else if (midV < nums[L]) {
                flag = true;
            } else {
                int start = L;
                while (start < mid && nums[start] == midV) {
                    start++;
                }
                if (start == mid) {
                    L = mid + 1;
                    continue;
                }
                flag = true;
            }
            if (flag) {
                if (nums[mid] < target) {
                    if (target < nums[L]) {
                        L = mid + 1;
                    } else if (nums[L] < target) {
                        R = mid - 1;
                    } else {
                        return true;
                    }
                } else {
                    R = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    L = mid + 1;
                } else {
                    if (target < nums[L]) {
                        L = mid + 1;
                    } else if (nums[L] < target) {
                        R = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}