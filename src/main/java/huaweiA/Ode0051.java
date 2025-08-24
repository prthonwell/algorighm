package huaweiA;

import java.util.*;

public class Ode0051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int blanks = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                blanks++;
            } else if (c == ']') {
                blanks--;
            } else if (c == '_') {
                if (blanks == 0) {
                    sb.append("(^|$|[,+])");
                    continue;
                }
            } else if (c == '\\') {
                sb.append('\\');
                if (i != n - 1) {
                    sb.append(s.charAt(i + 1));
                }
                i++;
                continue;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}
