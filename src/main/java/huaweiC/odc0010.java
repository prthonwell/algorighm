package huaweiC;

import java.util.Scanner;

public class odc0010 {


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        String[] ss = new String[n];
        for ( int i = 0; i < n; i++ ) {
            ss[i] = sc.next();
        }
        String learned = sc.next();
        int[] spec = new int[26];
        int num = 0;
        for ( int i = 0; i < learned.length(); i++ ) {
            char ch = learned.charAt( i );
            if ( ch == '?' ) num++;
            else spec[ch - 'a']++;
        }
        int res = 0;
        for ( int i = 0; i < n; i++ ) {
            int dif = 0;
            int[] curSpec = new int[26];
            for ( int j = 0; j < ss[i].length(); j++ ) {
                char ch = ss[i].charAt( j );
                curSpec[ch - 'a']++;
            }
            for ( int j = 0; j < spec.length; j++ ) {
                dif += Math.max(0, curSpec[j] - spec[j]);
            }
            if (dif <= num) res++;
        }
        System.out.println(res);
    }

}
