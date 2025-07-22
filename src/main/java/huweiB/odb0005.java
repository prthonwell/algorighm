package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '/') {
                if (sb.charAt(sb.length() - 1) == '/') continue;
                sb.append(c);
            }
            else if (c == ',') {
                if (i == s.length() - 1) break;
                if (sb.charAt(sb.length() - 1) == '/') continue;
                sb.append('/');
            }else {
                sb.append(c);
            }
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
