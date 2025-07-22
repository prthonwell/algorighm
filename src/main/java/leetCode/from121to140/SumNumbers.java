package leetCode.from121to140;

import ob.TreeNode;

class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] sum = new int[1];
        if (root.left == null && root.right == null) {
            return root.val;
        } else {
            if (root.left != null) dfs(sum, root.left, root.val);
            if (root.right != null) dfs(sum, root.right, root.val);
        }
        return sum[0];
    }

    private void dfs(int[] sum, TreeNode cur, int val) {
        val = val * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            sum[0] += val;
        } else {
            if (cur.left != null) dfs(sum, cur.left, val);
            if (cur.right != null) dfs(sum, cur.right, val);
        }
    }
}