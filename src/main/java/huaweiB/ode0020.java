package huaweiB;

import java.util.*;

public class ode0020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int len = sc.nextInt(), limit = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i + len - 1 < n; i++) {
            for (int j = 0; j + len - 1 < m; j++) {
                int sum = 0;
                for (int k = i; k < i + len; k++) {
                    for (int l = j; l < j + len; l++) {
                        sum += matrix[k][l];
                    }
                }
                if (sum >= limit) {
                    res++;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }

}
