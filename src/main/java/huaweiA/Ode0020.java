package huaweiA;

import java.util.*;

public class Ode0020 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        long sum = 0;
        int[] records = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            int c = sc.nextInt();
            sum += c;
            records[ i ] = c;
        }
        long total = sc.nextLong();
        if ( sum <= total ) {
            System.out.println(-1);
            return;
        }
        Arrays.sort( records );
        int right = records[ n - 1 ], left = 0;
        while ( left < right ) {
            int mid = (left + right + 1) / 2;
            if (check(records, mid, total)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int[] records, int mid, long total) {
        long sum = 0;
        for ( int i = 0; i < records.length; i++ ) {
            if ( records[ i ] > mid) {
                sum += mid;
            } else {
                sum += records[ i ];
            }
        }
        return sum <= total;
    }
    // 每次不用遍历计算结果
    public static void main2( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        long sum = 0;
        int[] records = new int[ n ];
        for ( int i = 0; i < n; i++ ) {
            int c = sc.nextInt();
            sum += c;
            records[ i ] = c;
        }
        long total = sc.nextLong();
        if ( sum <= total ) {
            System.out.println(-1);
            return;
        }
        Arrays.sort( records );
        int result = records[ n - 1 ];
        int i = n - 2;
        while ( total < sum ) {
            result--;
            while ( result < records[ i ] ) {
                i--;
            }
            sum -= n - 1 - i;
        }
        System.out.println(result);
    }
}