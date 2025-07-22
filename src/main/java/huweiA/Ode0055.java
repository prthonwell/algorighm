package huweiA;

import java.util.*;

public class Ode0055 {
    static class Node {
        int val;
        List<Node> children;
        public Node( int val ) {
            this.val = val;
            children = new ArrayList<Node>();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List< Node > nodes = new ArrayList< Node >();
        for (int i = 0; i < n; i++) {
            nodes.add( new Node( sc.nextInt() ) );
        }
        for (int i = 0; i < n - 1; i++) {
            Node father = nodes.get( sc.nextInt() - 1 );
            Node child = nodes.get( sc.nextInt() - 1 );
            father.children.add( child );
        }
        sc.close();
        int max = Integer.MIN_VALUE;
        for ( Node node : nodes ) {
            int num = node.val;
            for ( Node child : node.children ) {
                num += child.val;
            }
            max = Math.max( max, num );
        }
        System.out.println( max );
    }
}
