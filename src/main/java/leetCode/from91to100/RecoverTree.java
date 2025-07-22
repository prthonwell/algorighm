package leetCode.from91to100;

import ob.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

class RecoverTree {
    // https://leetcode.cn/problems/recover-binary-search-tree/
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode next = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val < prev.val) {
                next = cur;
                if (first == null) {
                    first = prev;
                }
            }
            prev = cur;
            list.add(cur.val);
            cur = cur.right;
        }
        int temp = first.val;
        first.val = next.val;
        next.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(root);
    }
}