package huweiA;

import java.util.*;

public class Ode0062 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Node {
        String val;
        Node Left;
        Node Right;
        Node(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] ss = s.split(" ");
        int n = ss.length, index = 0;
        if (n == 0) return;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(ss[index++]);
        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (index == n) break;
            cur.Left = new Node(ss[index++]);
            q.offer(cur.Left);
            if (index == n) break;
            cur.Right = new Node(ss[index++]);
            q.offer(cur.Right);
        }
        StringBuilder sb = new StringBuilder();
        PostOrder(sb, root.Left);
        PostOrder(sb, root.Right);
        sb.append(root.val).append(" ");
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void PostOrder(StringBuilder sb, Node cur) {
        if (cur == null || (cur.Left == null && cur.Right == null)) {
            return;
        }
        PostOrder(sb, cur.Left);
        PostOrder(sb, cur.Right);
        sb.append(cur.val).append(" ");;
    }
}
