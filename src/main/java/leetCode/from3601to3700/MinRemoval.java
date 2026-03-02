package leetCode.from3601to3700;

import java.util.Arrays;

class MinRemoval {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (exist(mid, nums, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - r;
    }

    private boolean exist(int mid, int[] nums, int k) {
        if (mid == 1) return true;
        int l =  0, r = mid - 1;
        while (r < nums.length) {
            if ((long)nums[l] * k >= (long)nums[r]) {
                return true;
            }
            r++;
            l++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5};
        MinRemoval mr = new MinRemoval();
        System.out.println(mr.minRemoval(a, 2));
    }
}