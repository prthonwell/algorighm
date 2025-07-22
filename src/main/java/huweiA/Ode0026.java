package huweiA;

import java.util.*;

public class Ode0026 {

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode( String val ) {
            this.val = val;
        }
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = new TreeNode( s.substring( 0, 1 ) );
        Stack<TreeNode> stack = new Stack<>();
        boolean left = true;
        TreeNode cur = root;
        for ( int i = 1; i < s.length(); i++ ) {
            char c = s.charAt( i );
            if ( c == '{') {
                stack.push( cur );
                left = true;
            } else if ( c == ',') {
                left = false;
            } else if ( c == '}' ) {
                cur = stack.pop();
            } else if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ) {
                int start = i;
                while ( (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ) {
                    i++;
                }
                if (left) {
                    cur = stack.peek();
                    cur.left = new TreeNode( s.substring( start, i ) );
                    cur = cur.left;
                } else {
                    cur = stack.peek();
                    cur.right = new TreeNode( s.substring( start, i ) );
                    cur = cur.right;
                }
                i--;
            }
        }
        List<String> res = new ArrayList<>();
        inorder(root, res);
        StringJoiner sj = new StringJoiner( "" );
        for (String str : res) {
            sj.add( str );
        }
        System.out.println( sj.toString() );
    }

    private static void inorder(TreeNode root, List<String> res) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push( cur );
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
    }


}