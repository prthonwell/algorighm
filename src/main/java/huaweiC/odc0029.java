package huaweiC;

import java.util.Scanner;

public class odc0029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        long k = sc.nextLong(), n = sc.nextLong(), m = sc.nextLong();
        if (n >= m) {
            System.out.println(0);
            return;
        }
        if (m == 1 || m == 0) {
            System.out.println( 0 );
            return;
        }
        long res = 0;
        while (k > 0) {
            long cur = k % m;
            if (cur == n) {
                res++;
            }
            k = k / m;
        }
        System.out.println(res);

    }

}
