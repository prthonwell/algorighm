package leetCode.from20to30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            process(nums[i], i + 1, nums, res);
        }
        return res;
    }

    private void process(int first, int start, int[] nums, List<List<Integer>> res) {
        int end = nums.length - 1;
        while (start < end) {
            if (first + nums[start] + nums[end] == 0) {
                res.add(new ArrayList<>(Arrays.asList(first, nums[start], nums[end])));
                start = moveToNext(nums, start);
            } else if (first + nums[start] + nums[end] < 0) {
                start = moveToNext(nums, start);
            } else {
                end = moveToPre(nums, end);
            }
        }
    }

    private int moveToNext(int[] nums, int index) {
        int tmp = nums[index];
        while (index < nums.length && nums[index] == tmp) {
            index++;
        }
        return index;
    }

    private int moveToPre(int[] nums, int index) {
        int tmp = nums[index];
        while (index >= 0 && nums[index] == tmp) {
            index--;
        }
        return index;
    }

}
