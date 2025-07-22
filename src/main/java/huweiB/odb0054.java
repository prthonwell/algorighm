package huweiB;

import java.util.*;

public class odb0054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt(), n = sc.nextInt();
        int start = (sum / n) - ((n - 1) / 2);
        StringJoiner sj = new StringJoiner( " " );
        int cur = 0;
        for ( int i = start; i < start + n; i++ ) {
            cur += i;
            sj.add( String.valueOf( i ) );
        }
        if (cur != sum) System.out.println(-1);
        else System.out.println( sj.toString() );
        sc.close();
    }
}
