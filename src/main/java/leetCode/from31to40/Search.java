package leetCode.from31to40;

class Search {
    // https://leetcode.cn/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                if (nums[mid] < nums[r]) {
                    r = mid - 1;
                } else {
                    if (target < nums[l]) {
                        l = mid + 1;
                    } else if (target == nums[l]) {
                        return l;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                if (nums[mid] > nums[l]){
                    l = mid + 1;
                } else {
                    if (target > nums[r]) {
                        r = mid - 1;
                    } else if (target == nums[r]) {
                        return r;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Search().search(nums, 0));
    }
}