package leetCode.from201to300;

import ob.TreeNode;

public class LowestCommonAncestor {
    class Info {
        TreeNode res;
        boolean left;
        boolean right;
        public Info(TreeNode cur, boolean left, boolean right) {
            res = cur;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return DFS(root, p, q).res;
    }

    private Info DFS(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return new Info(null, false, false);
        Info l = DFS(cur.left, p, q);
        Info r = DFS(cur.right, p, q);
        if (l.res != null || r.res != null) {
            return new Info(l.res != null ? l.res : r.res, true, true);
        }
        boolean left = l.left | r.left | cur == p;
        boolean right = l.right | r.right | cur == q;
        if (left && right) {
            return new Info(cur, true, true);
        }
        return new Info(null, left, right);
    }
}
