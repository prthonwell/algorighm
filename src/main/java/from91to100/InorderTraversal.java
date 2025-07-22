package from91to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            res.add(top.val);
            cur = top.right;
        }
        return res;
    }

    private void mid(TreeNode cur) {
        if (cur == null) return;
        mid(cur.left);
        res.add(cur.val);
        mid(cur.right);
    }
}