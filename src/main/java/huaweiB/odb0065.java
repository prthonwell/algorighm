package huaweiB;

import java.util.*;

public class odb0065 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[num][num];
        for (int i = 0; i < num; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            matrix[start][end] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            matrix[i][i] = 0;
        }

        // floyd
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    if (j == k || i == k || j == i) {
                        continue;
                    }
                    if (matrix[j][i] != Integer.MAX_VALUE && matrix[i][k] != Integer.MAX_VALUE) {
                        matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                    }
                }
            }
        }

        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        System.out.println(matrix[start][end] == Integer.MAX_VALUE ? -1 : matrix[start][end]);
    }
}
