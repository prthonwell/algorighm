import ob.BibaryNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    // 通过栈先序遍历树
    public static List<BibaryNode> preOrderTraversal(BibaryNode root) {
        Stack<BibaryNode> stack = new Stack<>();
        List<BibaryNode> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BibaryNode cur = stack.pop();
            res.add(cur);
            // 先右再左，取的时候先做后右
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

    // 通过栈中序遍历树
    public static List<BibaryNode> inOrderTraversal(BibaryNode root) {
        BibaryNode cur = root;
        Stack<BibaryNode> stack = new Stack<>();
        List<BibaryNode> res = new ArrayList<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur);
            cur = cur.right;
        }
        return res;
    }

    // 通过栈后序遍历树
    public static List<BibaryNode> postOrderTraversal(BibaryNode root) {
        BibaryNode cur = root;
        Stack<BibaryNode> stack = new Stack<>();
        List<BibaryNode> res = new ArrayList<>();
        BibaryNode last = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                BibaryNode node = stack.peek();
                if (node.right != null && node.right != last) {
                    cur = node.right;
                } else {
                    res.add(node);
                    last = stack.pop();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BibaryNode root = new BibaryNode(1);
        root.left = new BibaryNode(2);
        root.right = new BibaryNode(3);
        root.left.left = new BibaryNode(4);
        root.left.right = new BibaryNode(5);
        root.right.left = new BibaryNode(6);
        root.right.right = new BibaryNode(7);
        preOrderTraversal(root).stream().map(BibaryNode::getValue).forEach(System.out::print);
        System.out.println();
        inOrderTraversal(root).stream().map(BibaryNode::getValue).forEach(System.out::print);
        System.out.println();
        postOrderTraversal(root).stream().map(BibaryNode::getValue).forEach(System.out::print);
    }
}
