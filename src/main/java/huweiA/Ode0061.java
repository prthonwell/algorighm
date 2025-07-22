package huweiA;

import java.util.*;

public class Ode0061 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];
        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        sc.close();
        int indexA = 0, indexB = 0;
        while (indexA < m && indexB < n) {
            int numA = A[indexA];
            int numB = B[indexB];
            if (numA <= numB) {
                if (numB - numA <= R) {
                    System.out.println(numA + " " + numB);
                }
                indexA++;
            } else {
                indexB++;
            }
        }
    }
}
