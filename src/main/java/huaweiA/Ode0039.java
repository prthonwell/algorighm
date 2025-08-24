package huaweiA;

import java.util.*;

public class Ode0039 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split( "," );
        sc.close();
        int n = ss.length;
        int count = 0, zeros = 0, i = 0;
        while ( ss[i].equals("0") ) {
            zeros++;
            i++;
        }
        count += zeros / 2;
        zeros = 0;
        while ( ss[n - 1].equals("0") ) {
            zeros++;
            n--;
        }
        count += zeros / 2;
        zeros = 0;
        for (; i < n; i++ ) {
            if ( ss[i].equals("0") ) {
                zeros++;
            } else {
                count += (zeros - 1) / 2;
                zeros = 0;
            }
        }
        count += (zeros - 1) / 2;
        System.out.println( count );
    }

}