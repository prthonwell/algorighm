package huweiB;

import java.util.*;

public class ode0081 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), days = sc.nextInt();
        int[] item = new int[num];
        for (int i = 0; i < num; i++) {
            item[i] = sc.nextInt();
        }
        int[][] matrix = new int[num][days];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < days; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        int[] state = new int[2]; // 0 未持有 1 持有
        for (int i = 0; i < num; i++) {
            state[0] = 0;
            state[1] = -matrix[i][0];
            for (int j = 1; j < days; j++) {
                int a = Math.max(state[0], state[1] + matrix[i][j]);
                int b = Math.max(state[1], state[0] - matrix[i][j]);
                state[0] = a;
                state[1] = b;
            }
            res += state[0] * item[i];
        }
        System.out.println(res);
        sc.close();
    }
}
