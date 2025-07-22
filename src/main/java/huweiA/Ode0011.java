package huweiA;

import java.util.*;

public class Ode0011 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] res = new int[2][3];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] rows = new int[n];
        int[] cols = new int[n];
        for ( int i = 0; i < n; i++ ) {
            int sum = 0;
            for ( int j = 0; j < n; j++ ) {
                sum += arr[i][j];
            }
            rows[i] = sum;
        }
        for ( int i = 0; i < n; i++ ) {
            int sum = 0;
            for ( int j = 0; j < n; j++ ) {
                sum += arr[j][i];
            }
            cols[i] = sum;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( rows[i] > max ) {
                max = rows[i];
                x1 = i;
            }
            if ( rows[i] < min ) {
                min = rows[i];
                x2 = i;
            }
        }
        boolean sameRow = max == min;
        int distance = max - min;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for ( int i = 1; i < n; i++ ) {
            if ( cols[i] > max ) {
                max = cols[i];
                y1 = i;
            }
            if ( cols[i] < min ) {
                min = cols[i];
                y2 = i;
            }
        }
        boolean sameCol = max == min;
        distance = distance == 0 ? max - min : distance;
        if (sameRow) {
            for ( int i = 0; i < n; i++ ) {
                if ( Math.abs(arr[i][y1] - arr[i][y2]) == distance / 2) {
                    
                }
            }
        }

    }
}