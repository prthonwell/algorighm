package huaweiA;

import java.util.HashSet;
import java.util.Scanner;

public class Ode0040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int[] arr = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < n; i++ ) {
            set.add( arr[i] );
        }
        int[][] dp = new int[ n ][ n ];
        for ( int i = 0; i < n; i++ ) {
            set.remove( arr[i] );
            for ( int j = 0; j < n; j++ ) {
                if ( i == j ) continue;
                dp[i][j] = arr[i] + arr[j] * 2;
                set.remove( arr[j] );
                if (set.contains( dp[i][j] ) ) {
                    System.out.println( dp[i][j] + " " + arr[i] + " " + arr[j] );
                    return;
                }
                set.add( arr[j] );
            }
            set.add( arr[i] );
        }
        System.out.println(0);
    }
}
