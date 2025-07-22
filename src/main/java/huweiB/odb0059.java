package huweiB;

import java.util.*;

public class odb0059 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "1";
        while (n-- > 0) {
            s = process(s);
        }
        System.out.println(s);
        sc.close();
    }

    private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( count == 0) {
                count = 1;
            } else {
                if (c == s.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count + "").append(s.charAt(i - 1));
                    count = 1;
                }
            }
        }
        sb.append(count + "").append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}
