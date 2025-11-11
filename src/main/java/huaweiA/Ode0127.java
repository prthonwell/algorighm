package huaweiA;

import java.util.*;

public class Ode0127 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for ( int i = 0; i < n; i++ ) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        boolean flag = false;
        while ( index < n ) {
            map.put( a[index], map.getOrDefault( a[index], 0) + 1 );
            index++;
            if ( map.get( a[index - 1] ) == k ) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println( 0 );
        } else {
            long res = 0;
            for ( int i = 0; i < n; i++ ) {
                res += n - index + 1;
                map.put( a[i], map.get( a[i] ) - 1 );
                if ( map.get( a[i] ) == k - 1 ) {
                    flag = false;
                    while (index < n) {
                        map.put( a[index], map.getOrDefault( a[index], 0) + 1 );
                        index++;
                        if ( map.get( a[index - 1] ) == k ) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println(res);
                        return;
                    }
                }
            }
        }
    }
}