package huweiA;

import java.util.*;

public class Ode0038 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split( "," );
        sc.close();
        int n = ss.length;
        int[] a = new int[2 * n];
        for ( int i = 0; i < n; i++ ) {
            a[i] = Integer.parseInt( ss[i] );
            a[i + n] = a[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push( 0 );
        int[] res = new int[n];
        Arrays.fill( res, -1 );
        for ( int i = 1; i < 2 * n; i++ ) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()] ) {
                int j = stack.pop();
                if ( j >= n ) {
                    continue;
                }
                res[j] = a[i];
            }
            stack.push( i );
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < n; i++ ) {
            sb.append(res[i]).append(",");
        }
        System.out.println( sb.substring( 0, sb.length() - 1 ) );
    }

}