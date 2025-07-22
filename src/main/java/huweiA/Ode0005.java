package huweiA;

import java.util.*;

public class Ode0005 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<String> res = new Stack<>();
        for ( int i = s.length() - 1; i >= 0; i-- ) {
            char c = s.charAt(i);
            if ( c == '.' || c == '?' || c == ',' ||  c == ' ' ) {
                if (sb.isEmpty()) {
                    res.push(String.valueOf(c));
                    continue;
                }
                res.push(sb.toString());
                sb = new StringBuilder();
                res.push(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        res.push(sb.toString());
        sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pop());
        }
        System.out.println(sb.toString());
    }
}