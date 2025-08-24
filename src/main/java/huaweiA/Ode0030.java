package huaweiA;

import java.util.*;

public class Ode0030 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ss = new String[n];
        for ( int i = 0; i < n; i++ ) {
            ss[i] = sc.next();
        }
        sc.close();
        int[][] arr = new int[n][n];
        for ( int i = 0; i < n; i++ ) {
            String[] lr = ss[i].split(",");
            for ( int j = 0; j < n; j++ ) {
                arr[i][j] = Integer.parseInt( lr[j] );
            }
        }
        int[][] arr2 = new int[n][2 * n];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < 2 * n; j++ ) {
                arr2[i][j] = arr[i][j % n];
            }
        }
        int res = 0;
        for ( int i = 0; i < n; i++ ) {
            int col = 0;
            for ( int j = 0; j < n; j++ ) {
                int cur = 0;
                for ( int k = j; k < n + j; k++ ) {
                    cur += arr2[i][k] << (n - k + j - 1);
                }
                col = Math.max(col, cur);
            }
            res += col;
        }
        System.out.println( res );
    }
}