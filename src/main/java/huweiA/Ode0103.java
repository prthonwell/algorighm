package huweiA;

import java.util.*;

public class Ode0103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] brick = new int[n];
        for (int i = 0; i < n; i++) {
            brick[i] = sc.nextInt();
        }
        sc.close();
        int fei = brick[0], min = brick[0], sum = brick[0];
        for (int i = 1; i < n; i++) {
            sum += brick[i];
            min = Math.min(min, brick[i]);
            fei ^= brick[i];
        }
        if (fei != 0) {
            System.out.println("NO");
            return;
        }
        System.out.println(sum - min);
    }
}
