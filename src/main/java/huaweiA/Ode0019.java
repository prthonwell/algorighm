package huaweiA;

import java.util.*;

public class Ode0019 {
    public static void main( String[] args ) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Integer> offMap = new HashMap<>();
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int in = sc.nextInt();
            int off = sc.nextInt();
            max = Math.max( max, in );
            max = Math.max( max, off );
            if ( inMap.containsKey( in ) ) {
                inMap.put( in, inMap.get( in ) + 1 );
            } else {
                inMap.put( in, 1 );
            }
            if ( offMap.containsKey( off ) ) {
                offMap.put( off, offMap.get( off ) + 1 );
            } else {
                offMap.put( off, 1 );
            }
        }
        // 转两圈
        int res = 0, num = 0, m = 0, leave = 0;
        int circle = 2;
        while ( circle-- > 0 ) {
            for (int i = 1; i <= max; i++) {
                num -= leave;
                if ( inMap.containsKey( i ) ) {
                    num += inMap.get( i );
                }
                leave = offMap.getOrDefault(i, 0);
                if (num > m) {
                    res = i;
                    m = num;
                }
            }

        }
        System.out.println( res );
    }
}