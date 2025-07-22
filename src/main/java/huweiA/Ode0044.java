package huweiA;

import java.util.*;

public class Ode0044 {
    static class Node {
        char name;
        Node left, right;
        Node( char name ) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] words = s.split(" ");
        int n = words[0].length();
        Node root = build(words, n);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node cur = q.poll();
            sb.append(cur.name);
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        System.out.println(sb);
    }

    private static Node build(String[] words, int n) {
        if (words[1].isEmpty()) return null;
        char head = words[0].charAt(n - 1);
        Node cur = new Node( head );
        for (int i = 0; i < n; i++) {
            if (words[1].charAt(i) == head) {
                cur.left = build(
                        new String[] {
                                words[0].substring(0, i),
                                words[1].substring(0, i) },
                        i );
                cur.right = build(
                        new String[] {
                                words[0].substring(i, n - 1),
                                words[1].substring(i + 1)},
                        n - i - 1 );
            }
        }
        return cur;
    }
}
