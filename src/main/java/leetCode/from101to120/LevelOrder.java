package leetCode.from101to120;

import ob.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int count = 1;
        while (!stack.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int next = 0;
            for (int i = 0; i < count; i++) {
                TreeNode c = stack.poll();
                cur.add(c.val);
                if (c.left != null) {
                    next++;
                    stack.add(c.left);
                }
                if (c.right != null) {
                    next++;
                    stack.add(c.right);
                }
            }
            res.add(cur);
            count = next;
        }
        return res;
    }
}