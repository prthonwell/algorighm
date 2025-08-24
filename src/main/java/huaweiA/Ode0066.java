package huaweiA;

import java.util.*;

public class Ode0066 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring( 1, s.length() - 1 );
        String[] split = s.split(",");
        int min = Integer.MAX_VALUE;
        for ( int i = 0; i < split.length; i++ ) {
            int n = split[i].length();
            split[i] = split[i].substring( 1, n - 1 );
            min = Math.min( min, n - 2 );
        }
        int len = 1;
        String str = "";
        while ( len <= min ) {
            boolean matched = true;
            str = split[0].substring( split[0].length() - len);
            for ( int i = 1; i < split.length; i++ ) {
                String cur = split[i].substring( split[i].length() - len );
                if ( !str.equals( cur ) ) {
                    matched = false;
                }
            }
            if ( !matched ) {
                if (len == 1) {
                    System.out.println("@Zero");
                } else {
                    System.out.println(str.substring( 1));
                }
                return;
            }
            len++;
        }
        System.out.println(str);
    }
}
