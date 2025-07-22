package from101to120;

import ob.TreeNode;

class SortedArrayToBST {
    // https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/ 108
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return build(nums, 0, n - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }
}