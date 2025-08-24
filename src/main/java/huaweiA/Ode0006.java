package huaweiA;

import java.util.*;

public class Ode0006 {
    static class Node {
        int val;
        String next;
        Node( int val, String next ) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String head = sc.next();
        int n = sc.nextInt();
        HashMap< String, Node> map = new HashMap<>();
        for ( int i = 0; i < n; i++ ) {
            String s = sc.next();
            int val = sc.nextInt();
            String next = sc.next();
            Node node = new Node (val, next);
            map.put( s, node );
        }
        Node slow = map.get( head );
        Node fast = map.get( head );
        while ( !fast.next.equals("-1") ) {
            fast = map.get( fast.next );
            slow = map.get( slow.next );
            if ( !fast.next.equals("-1") ) {
                fast = map.get( fast.next );
            } else {
                break;
            }
        }
        System.out.println( slow.val );
    }
}