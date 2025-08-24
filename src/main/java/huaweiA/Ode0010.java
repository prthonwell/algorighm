package huaweiA;

import java.util.*;

public class Ode0010 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (map.containsKey( c )) {
                map.put( c, map.get( c ) + 1 );
            } else {
                map.put( c, 1 );
            }
        }
        int m = sc.nextInt(), res = 0;
        for (int i = 0; i < m; i++) {
            int c = sc.nextInt();
            if (map.containsKey( c )) {
                res += map.get( c );
            }
        }
        System.out.println( res );
    }
}