package leetCode.from31to40;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CombinationSum2 {
    // https://leetcode.cn/problems/combination-sum-ii/ 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> list = Arrays.stream(candidates)  // 转为 IntStream
                .sorted()
                .boxed()       // 装箱：int → Integer
                .collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, target, list, new ArrayList<Integer>(), 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, int target, ArrayList<Integer> candidates, ArrayList<Integer> cur, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            if (candidates.get(i) > target) break;
            int num = candidates.get(i);
            if (i > start && candidates.get(i) == candidates.get(i - 1)) {
                continue;
            }
            cur.add(num);
            dfs(res, target - num, candidates, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}