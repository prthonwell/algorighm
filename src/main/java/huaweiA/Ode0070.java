package huaweiA;

import java.util.*;

public class Ode0070 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int run = sc.nextInt();
        int n = sc.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }
        int accumulate = 0;
        for (int i = 0; i < n; i++) {
            accumulate = Math.max(accumulate + tasks[i] - run, 0);
        }
        int extra = accumulate / run + (accumulate % run == 0 ? 0 : 1);
        System.out.println(extra + n);
    }
}
