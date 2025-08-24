package huaweiA;

import java.util.Scanner;

public class Ode0043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int search = sc.nextInt();
        sc.close();
        System.out.println(start(search - 1, matrix));
    }

    private static int start(int search, int[][] matrix) {
        int res = 0;
        for ( int i = 0; i < matrix.length; i++ ) {
            if (i == search) continue;
            if ( matrix[search][i] == 1 ) {
                res = Math.max(res, start(i, matrix));
            }
        }
        return res + matrix[search][search];
    }
}
