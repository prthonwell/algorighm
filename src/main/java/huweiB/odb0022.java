package huweiB;

import java.util.*;

public class odb0022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int r = s.length();
        int index = 0;
        for (int i = 0; i < k; i++) {
            String[] command = sc.nextLine().split(" ");
            if (command[0].equals("FORWARD")) {
                index += Integer.parseInt(command[1]);
                index = Math.min(index, r);
            } else if (command[0].equals("BACKWARD")) {
                index -= Integer.parseInt(command[1]);
                index = Math.max(index, 0);
            } else if (command[0].equals("INSERT")) {
                sb.insert(index, command[1]);
                r = sb.length();
                index += command[1].length();
            } else if (command[0].equals("DELETE")) {
                int len = Integer.parseInt(command[1]);
                sb.delete(index, Math.min(r, index + len));
                r = sb.length();
            } else if (command[0].equals("REPLACE")) {
                int len = command[1].length();
                sb.delete(index, Math.min(r, index + len));
                sb.insert(index, command[1]);
                r = sb.length();
            } else if (command[0].equals("SEARCH-FORWARD")) {
                index = find(index, sb, command[1], true);
            } else {
                index = find(index, sb, command[1], false);
            }
        }
        System.out.println(sb);
    }

    private static int find(int index, StringBuilder sb, String s, boolean forward) {
        if (forward) {
            for (int i = index; i < sb.length(); i++) {
                if (sb.charAt(i) == s.charAt(0)) {
                    int a = i + 1;
                    int b = 1;
                    while (a < sb.length() && b < s.length() && s.charAt(b) == sb.charAt(a)) {
                        a++;
                        b++;
                    }
                    if (b == s.length()) {
                        return i;
                    }
                }
            }
        } else {
            int n = s.length();
            for (int i = Math.min(index, sb.length() - 1); i >= 0; i--) {
                if (sb.charAt(i) == s.charAt(n - 1)) {
                    int a = i - 1;
                    int b = n - 2;
                    while (a >= 0 && b >= 0 && sb.charAt(a) == s.charAt(b)) {
                        a--;
                        b--;
                    }
                    if (b < 0) {
                        return a + 1;
                    }
                }
            }
        }
        return index;
    }
}
