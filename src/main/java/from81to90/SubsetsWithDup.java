package from81to90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsWithDup {
    // https://leetcode.cn/problems/subsets-ii/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            dfs (nums, i, 0, 0, new ArrayList<>(), res);
        }
        return res;
    }

    private void dfs(int[] nums, int len, int inedx, int cur, ArrayList<Integer> path, List<List<Integer>> res) {
        if (cur == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = inedx; i < nums.length; i++) {
            if (i != inedx && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, len, i + 1, cur + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2}));
    }
}