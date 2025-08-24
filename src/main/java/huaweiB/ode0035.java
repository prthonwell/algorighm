package huaweiB;

import java.util.*;

public class ode0035 {

    static class Node {
        int val;
        int high;
        Node left;
        Node right;
        Node(int val, int high ) {
            this.val = val;
            this.high = high;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> list = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val == o2.val ? o1.high - o2.high : o1.val - o2.val;
            }
        });
        for (int i = 0; i < n; i++) {
            list.add( new Node( sc.nextInt() , 1) );
        }
        while (list.size() > 1) {
            Node l = list.poll();
            Node r = list.poll();
            Node root = new Node( l.val + r.val , Math.max(l.high, r.high) + 1 );
            root.left = l;
            root.right = r;
            list.add( root );
        }
        Node root = list.poll();
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for (Integer integer : res) {
            System.out.print( integer + " " );
        }
        sc.close();
    }

    private static void inOrder(Node root, List<Integer> res) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while ( curr != null || !stack.isEmpty() ) {
            while ( curr != null ) {
                stack.push( curr );
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
    }
}
