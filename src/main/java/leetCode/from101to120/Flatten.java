package leetCode.from101to120;

import ob.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(curr);
        while (curr.left != null || !stack.isEmpty()) {
            while (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (curr.right != null) {
                curr.left = curr.right;
                curr.right = null;
            } else {
                TreeNode node = stack.pop();
                curr.left = node.right;
                node.right = null;
            }
        }
        curr = root;
        while (curr != null) {
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Flatten flatten = new Flatten();
        flatten.flatten(root);
        TreeNode curr = root;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
}
