package huaweiA;

import java.util.*;

public class Ode0125 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = sc.nextInt();
        }
        int[] spec = new int[31];
        for ( int i = 0; i < n; i++ ) {
            for (int timer = 30; timer > 0; timer--) {
                if (arr[i] / (1 << timer) != 0) {
                    spec[timer]++;
                    break;
                }
            }
        }
        int sum = 0;
        int[] sums = new int[31];
        for ( int i = 30; i >= 0; i-- ) {
            sum += spec[i];
            sums[i] = sum;
        }
        long res = 0;
        for (int i = 0; i < 30; i++) {
            res += (long) sums[i + 1] * spec[i];
        }
        System.out.println(res);
    }
}