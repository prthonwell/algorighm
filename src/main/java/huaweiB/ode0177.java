package huaweiB;

import java.util.*;

public class ode0177 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] matrix = new boolean[201][201];
        int offset = 100;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            if (str.equals("d")) {
                for (int j = x1 + offset; j < x2 + offset; j++) {
                    for (int k = y2 + offset; k < y1 + offset; k++) {
                        matrix[j][k] = true;
                    }
                }
            } else {
                for (int j = x1 + offset; j < x2 + offset; j++) {
                    for (int k = y2 + offset; k < y1 + offset; k++) {
                        matrix[j][k] = false;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (matrix[i][j]) {
                    res++;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }

}
