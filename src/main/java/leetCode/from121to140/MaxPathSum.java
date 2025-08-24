package leetCode.from121to140;

import ob.TreeNode;

class MaxPathSum {
    // https://leetcode.cn/problems/binary-tree-maximum-path-sum/ 124
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        int left = find(res, root.left);
        int right = find(res, root.right);
        res[0] = Math.max(res[0], left + right + root.val);
        return res[0];
    }

    private int find(int[] res, TreeNode cur) {
        if (cur == null) return 0;
        int left = find(res, cur.left);
        int right = find(res, cur.right);
        res[0] = Math.max(res[0], left + right + cur.val);
        return Math.max(0,Math.max(left, right) + cur.val);
    }

    public static void main(String[] args) {
        String s = "asdasfa";
        char[] chars = s.toCharArray();
    }
}