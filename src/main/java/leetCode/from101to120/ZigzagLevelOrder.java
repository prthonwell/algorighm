package leetCode.from101to120;

import com.sun.source.tree.Tree;
import ob.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int level = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            level++;
            Deque<TreeNode> temp = new LinkedList<>();
            List<Integer> curLevel = new LinkedList<>();
            if (level % 2 == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = dq.pollLast();
                    curLevel.add(cur.val);
                    if (cur.left != null) temp.offer(cur.left);
                    if (cur.right != null) temp.offer(cur.right);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = dq.pollLast();
                    curLevel.add(cur.val);
                    if (cur.right != null) temp.offer(cur.right);
                    if (cur.left != null) temp.offer(cur.left);
                }
            }
            while (!temp.isEmpty()) {
                dq.offer(temp.pollFirst());
            }
            res.add(curLevel);
        }
        return res;
    }
}
