package huaweiA;

import java.util.*;

public class Ode0065 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int count = 1;
                i++;
                int start = i;
                while (i < s.length()) {
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    if (s.charAt(i) == ')') {
                        count--;
                        if (count == 0) {
                            sb.append(solve(s.substring(start, i)));
                            break;
                        }
                    }
                    i++;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);

    }

    private static String solve(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int count = 1;
                i++;
                int start = i;
                while (i < s.length()) {
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    if (s.charAt(i) == ')') {
                        count--;
                        if (count == 0) {
                            sb.append(solve(s.substring(start, i)));
                            break;
                        }
                    }
                    i++;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}
