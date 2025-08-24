package leetCode.from91to100;

import ob.TreeNode;

import java.util.ArrayList;
import java.util.List;

class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftRes = dfs(left, i - 1);
            List<TreeNode> rightRes = dfs(i + 1, right);
            for (TreeNode l : leftRes) {
                for (TreeNode r : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        GenerateTrees gt = new GenerateTrees();
        System.out.println(gt.generateTrees(3).size());
    }
}