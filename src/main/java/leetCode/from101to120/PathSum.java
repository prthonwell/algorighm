package leetCode.from101to120;

import ob.TreeNode;

import java.util.ArrayList;
import java.util.List;

class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, new ArrayList<>(), root, targetSum);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, TreeNode cur, int targetSum) {
        int v = cur.val;
        path.add(v);
        if (cur.left == null && cur.right == null) {
            if (v == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            if (cur.left != null) dfs(res, path, cur.left, targetSum - v);
            if (cur.right != null) dfs(res, path, cur.right, targetSum - v);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(root, 22));
    }
}