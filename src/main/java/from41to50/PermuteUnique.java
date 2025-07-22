package from41to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermuteUnique {
    // https://leetcode.cn/problems/permutations-ii/ 47
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, used, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
               continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(res, nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}