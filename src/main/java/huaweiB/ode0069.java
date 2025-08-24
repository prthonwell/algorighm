package huaweiB;

import java.util.*;

public class ode0069 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE, sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            min = Math.min(min, a);
            sum1 ^= a;
            sum2 += a;
        }
        if (sum1 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum2 - min);
        }
    }
}
