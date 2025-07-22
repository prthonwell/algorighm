package leetCode.from31to40;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    // https://leetcode.cn/problems/combination-sum/ 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, target, candidates, 0,new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int target, int[] candidates,int start, ArrayList<Integer> cur) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(cur);
            res.add(tmp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            int num = candidates[i];
            cur.add(num);
            dfs(res, target - num, candidates, i, cur);
            cur.remove(cur.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}