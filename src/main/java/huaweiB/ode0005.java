package huaweiB;

import java.util.*;

public class ode0005 {
    static class Node {
        int val;
        Node next;
        Node pre;
        Node( int val ) {
            this.val = val;
        }
    }
    static class loopNode {
        Node head;
        Node tail;
        loopNode( Node head, Node tail ) {
            this.head = head;
            this.tail = tail;
        }

        void add (Node node) {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }

        void loop () {
            tail.next = head;
            head.pre = tail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if (M <= 1 || M >= 100) {
            System.out.println("ERROR!");
            return;
        }

        Node head = new Node( 1 );
        loopNode lNode = new loopNode( head, head);
        for (int i = 2; i <= 100; i++) {
            lNode.add( new Node( i ) );
        }
        lNode.loop();
        int count = 0;
        Node cur = lNode.head;
        while (count <= 100 - M) {
            for (int i = 1; i < M; i++) {
                cur = cur.next;
            }
            Node next = cur.next;
            cur.pre.next = next;
            next.pre = cur.pre;
            cur = next;
            count++;
        }
        Node start = cur;
        List<Integer> res = new ArrayList<>();
        res.add( start.val );
        cur = cur.next;
        while (cur != start) {
            res.add( cur.val);
            cur = cur.next;
        }
        res.sort(Integer::compareTo);
        StringJoiner sj = new StringJoiner( "," );
        for (Integer i : res) sj.add( i + "" );
        System.out.println( sj.toString() );
        sc.close();
    }
}
