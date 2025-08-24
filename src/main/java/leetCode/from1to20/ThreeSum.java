package leetCode.from1to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int pre = nums[j];
                    while (j < k && nums[j] == pre) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    int pre = nums[j];
                    while (j < k && nums[j] == pre) j++;
                } else {
                    int pre = nums[k];
                    while (j < k && nums[k] == pre) k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
