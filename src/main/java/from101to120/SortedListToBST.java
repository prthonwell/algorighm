package from101to120;

import ob.ListNode;
import ob.TreeNode;

class SortedListToBST {
    ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int n = 0;
        cur = head;
        while (head != null) {
            head = head.next;
            n++;
        }

        return build(0,n - 1);
    }

    private TreeNode build(int start, int end) {
        if (start > end) return null;
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = build(start, mid - 1);
        root.val = cur.val;
        cur = cur.next;
        root.right = build(mid + 1, end);
        return root;
    }
}