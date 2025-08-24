package huaweiA;

import java.util.*;

public class Ode0063 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Node {
        int val;
        Node Left;
        Node Right;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] ss = s.split(" ");
        int n = ss.length, preVal = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        Node root = new Node(arr[0]);
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (cur.val == arr[i]) {
                System.out.println(0 + " " + 0 + " " + 0);
                return;
            }
            if (arr[i] < cur.val) {
                if (arr[i] <= preVal) {
                    System.out.println(0 + " " + 0 + " " + 0);
                    return;
                }
                cur.Left = new Node(arr[i]);
                stack.push(cur);
                cur = cur.Left;
            } else {
                while (!stack.isEmpty() && arr[i] > stack.peek().val) {
                    cur = stack.pop();
                }
                preVal = cur.val;
                cur.Right = new Node(arr[i]);
                cur = cur.Right;
            }
        }
        int left = getLeft(root);
        int right = getRight(root);
        left = left == root.val ? 0 : left;
        right = right == root.val ? 0 : right;
        System.out.println(1 + " " + left + " " + right);
    }

    private static int getRight(Node root) {
        if (root.Right != null) {
            return getRight(root.Right);
        }
        if (root.Left != null) {
            return getRight(root.Left);
        }
        return root.val;
    }

    private static int getLeft(Node root) {
        if (root.Left != null) {
            return getLeft(root.Left);
        }
        if (root.Right != null) {
            return getLeft(root.Right);
        }
        return root.val;
    }
}
