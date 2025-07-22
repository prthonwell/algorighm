package huweiA;

import java.util.*;

public class Ode0016 {
    public static void main( String[] args ) {
        HashSet<Integer> set = new HashSet<>();
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        int[][] connected = new int[ N ][ N ];
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                connected[ i ][ j ] = sc.nextInt();
            }
        }
        int res = 0;
        while ( !set.isEmpty() ) {
            int head = set.iterator().next();
            res++;
            set.remove( head );
            HashSet<Integer> connectedList = new HashSet<>();
            for ( int i = 0; i < N; i++ ) {
                if ( connected[ head ][ i ] == 1 && set.contains( i ) ) {
                    connectedList.add( i );
                    set.remove( i );
                }
            }
            while ( !connectedList.isEmpty() ) {
                int cur = connectedList.iterator().next();
                connectedList.remove(cur);
                for ( int i = 0; i < N; i++ ) {
                    if ( connected[ cur ][ i ] == 1  && set.contains( i ) ) {
                        connectedList.add( i );
                        set.remove( i );
                    }
                }

            }
        }
        System.out.println(res);
    }
}