package huaweiB;

import java.util.*;

public class odb0034 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] unChange = new long[n + 1];
        long[] Change = new long[n + 1];
        Arrays.fill( unChange, -1 );
        Arrays.fill( Change, -1 );
        long a = WithChange(Change, n);
        long b = UnChange(unChange, n, n % 2 == 0);
        System.out.println( a + b - 1 );
    }

    private static long UnChange(long[] unChange, int n, boolean even) {
        if (unChange[n] != -1) return unChange[n];
        long sum = 1;
        int half = n / 2;
        if (even ^ half % 2 != 1) {
            half--;
        }
        while (half > 0) {
            sum += UnChange(unChange, half, even);
            half-=2;
        }
        unChange[n] = sum;
        return sum;
    }

    private static long WithChange(long[] change, int n) {
        if (change[n] != -1) return change[n];
        long sum = 1;
        int half = n / 2;
        if (n % 2 == 0 ^ half % 2 != 0) {
            half--;
        }
        while (half > 0) {
            sum += WithChange(change, half);
            half-=2;
        }
        change[n] = sum;
        return sum;
    }
}
