package huweiB;

import java.util.*;

public class ode0011  {

    static class Node {
        int v;
        String N;
        Node next;
        Node( int v , String N ) {
            this.v = v;
            this.N = N;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        int n = sc.nextInt();
        HashMap< String, Node > map = new HashMap< String, Node >();
        for ( int i = 0; i < n; i++ ) {
            String addr = sc.next();
            int v = sc.nextInt();
            String next = sc.next();
            Node node = new Node( v , next);
            map.put( addr , node );
        }
        for (Node node : map.values()) {
            if ( node.N.equals("-1") ) node.next = null;
            else node.next = map.get( node.N );
        }
        Node s = map.get( start );
        Node f = s;
        while ( f.next != null ) {
            s = s.next;
            f = f.next;
            if ( f.next == null ) break;
            f = f.next;
        }
        System.out.println(s.v);
        sc.close();
    }
}
