package from101to120;

import ob.TreeNode;

class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        if (n == 0 || m == 0 || n != m) return null;
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        if (pStart == pEnd) return new TreeNode(preorder[pStart]);
        int rootVal = preorder[pStart];
        int count = 0;
        for (; iStart + count <= iEnd; count++) {
            int i = iStart + count;
            if (inorder[i] == rootVal) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, pStart + 1, pStart + count, inorder, iStart, iStart + count - 1);
        root.right = build(preorder, pStart + count + 1, pEnd, inorder, iStart + count + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.buildTree(preorder, inorder);
    }
}