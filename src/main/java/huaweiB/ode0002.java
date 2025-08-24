package huaweiB;

import java.util.*;

public class ode0002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String target = sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        for ( int i = 0; i < str.length; ) {
            String T = str[i];
            int len = Integer.parseInt(str[i+2] + str[i+1], 16);
            if (T.equals(target)) {
                StringJoiner sj = new StringJoiner( " " );
                for (int j = i + 3; j < i + 3 + len; j++ ) {
                    sj.add( str[j] );
                }
                System.out.println(sj.toString());
                return;
            } else {
                i += 3 + len;
            }
        }
        sc.close();
    }
}
