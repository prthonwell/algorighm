package huaweiB;

import java.util.*;

public class ode0055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int m = s.length();
        int index = 0;
        while (index < m && s.charAt(index) != '-') {
            index++;
        }
        StringJoiner sj = new StringJoiner( "-");
        sj.add( s.substring( 0, index ) );
        while (index < m) {
            StringBuilder cur = new StringBuilder();
            int countLow = 0, countUP = 0;
            while (index < m && cur.length() < n) {
                char c = s.charAt(index++);
                if (c == '-') continue;
                if (c >= 'a' && c <= 'z') {
                    countLow++;
                } else if (c >= 'A' && c <= 'Z') {
                    countUP++;
                }
                cur.append( c );
            }
            if (countLow < countUP) {
                sj.add( cur.toString().toUpperCase() );
            } else if (countUP < countLow) {
                sj.add( cur.toString().toLowerCase() );
            } else {
                sj.add( cur.toString() );
            }
        }
        sc.close();
        System.out.println( sj.toString() );
    }
}
