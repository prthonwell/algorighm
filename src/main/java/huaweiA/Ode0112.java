package huaweiA;

import java.util.*;

public class Ode0112 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        char[] shorter = s1.toCharArray();
        char[] longer = s2.toCharArray();
        int n = shorter.length;
        int m = longer.length;
        int max = 0;
        for ( int i = 0; i < n; i++ ) {
            int index = i;
            for ( int j = 0; j < m; j++ ) {
                if ( shorter[index] == longer[j] ) {
                    index++;
                    if ( index == n) {
                        max = Math.max(max, index - i);
                        break;
                    }
                } else {
                    j -= index - i;
                    if (index - i>0) {
                        max = Math.max(max, index - i);
                        index = i;
                    }
                }
            }
        }
        sc.close();
        System.out.println(max);
    }

}
