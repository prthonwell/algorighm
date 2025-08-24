package leetCode.from41to50;

import java.util.ArrayList;
import java.util.List;

class Permute {
    //https://leetcode.cn/problems/permutations/ 46
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, used, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(res, nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}