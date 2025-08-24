package huaweiB;

import java.util.*;

public class ode0064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (b < 128) {
                res = Math.min(res, a + b);
            } else {
                int mant = b % 16;
                int exp = b / 16 - 8;
                res = Math.min(res, a + (mant + 16) << (exp + 3));
            }
        }
        sc.close();
        System.out.println(res);
    }
}
