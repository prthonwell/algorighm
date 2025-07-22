package huweiB;

import java.util.*;

public class ode0138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0, n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == 'M') {
                if (i + 1 < n && s.charAt(i + 1) == 'I') {
                    res++;
                    chars[i] = 'R';
                    chars[i + 1] = 'R';
                    if (i + 2 < n && s.charAt(i + 2) == 'M') {
                        chars[i + 2] = 'R';
                    }
                    continue;
                }
                if (i - 1 < 0 || s.charAt(i - 1) != 'I') {
                    System.out.println(-1);
                    return;
                } else {
                    res++;
                    chars[i - 1] = 'R';
                    chars[i] = 'R';
                }
            }
        }
        System.out.println(res);
    }

}
