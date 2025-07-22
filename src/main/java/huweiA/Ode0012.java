package huweiA;

import java.util.*;

public class Ode0012 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[] table = new int[128];
        for ( int i = 0; i < n; i++ ) {
            table[ss[i] - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 128; i++) {
            int cur = table[i] / 2;
            for (int j = 0; j < cur; j++) {
                sb.append((char)('A' + i));
                table[i] -= 2;
            }
        }
        String reversed = sb.reverse().toString();
        sb.reverse();
        for ( int i = 0; i < 128; i++) {
            if ( table[i] > 0 ) {
                sb.append((char)('A' + i));
                break;
            }
        }
        String res = sb + reversed;
        System.out.println(res);
    }
}