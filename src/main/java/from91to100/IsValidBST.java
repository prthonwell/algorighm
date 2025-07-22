package from91to100;

import ob.TreeNode;

class IsValidBST {
    // https://leetcode.cn/problems/validate-binary-search-tree/ 98
    public class MyNode extends TreeNode {
        int max;
        int min;
        boolean isValidST;
        MyNode(TreeNode T) {
            this.val = T.val;
            this.left = T.left;
            this.right = T.right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        MyNode r = new MyNode(root);
        return bfs(r).isValidST;
    }
    public MyNode bfs (MyNode cur) {
        MyNode l = cur.left == null ? null : bfs(new MyNode(cur.left));
        MyNode r = cur.right == null ? null : bfs(new MyNode(cur.right));
        int max = cur.val;
        int min = cur.val;
        boolean isST = true;
        if (l != null) {
            min = l.min;
            isST = cur.val > l.max && l.isValidST;
        }
        if (r != null) {
            max = r.max;
            isST = cur.val < r.min && r.isValidST && isST;
        }
        MyNode res = new MyNode(cur);
        res.min = min;
        res.max = max;
        res.isValidST = isST;
        return res;
    } 
}