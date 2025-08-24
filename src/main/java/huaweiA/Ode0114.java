package huaweiA;

import java.util.*;

public class Ode0114 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        boolean hasNum = false;
        for ( int i = 0; i < chars.length; i++ ) {
            if ( chars[i] >='0' && chars[i] <='9' ) {
                hasNum = true;
            }
        }
        if(!hasNum) {
            System.out.println(-1);
            return;
        }
        int before = 0, after = 0;
        boolean first = true;
        int res = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                if (first) {
                    first = false;
                } else {
                    res = Math.max(res, after + before + 1);
                    before = after;
                    after = 0;
                }
            } else {
                if (first) {
                    before++;
                } else {
                    after++;
                }
            }
        }
        if (!first) {
            res = Math.max(res, after + before + 1);
        }
        sc.close();
        System.out.println(res);
    }
}
