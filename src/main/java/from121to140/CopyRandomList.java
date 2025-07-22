package from121to140;

class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node Next = cur.next;
            cur.next = new Node(cur.val);
            cur = cur.next;
            cur.next = Next;
            cur = Next;
        }
        cur = head;
        while (cur != null) {
            Node Next = cur.next;
            Next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node newCur = cur.next;
            Node Next = newCur.next;
            if (Next != null) {
                newCur.next = Next.next;
            } else {
                newCur.next = Next;
            }
            cur.next = Next;
            cur = Next;
        }
        return res;
    }
}