package leetCode.from301to400;

import java.util.ArrayDeque;
import java.util.Deque;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = Math.min(second, nums[i]);
            } else {
                first = Math.min(first, nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,2147483647,1,2};
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(arr));
    }
}
