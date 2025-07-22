package huweiB;

import java.util.*;

public class ode0147 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        sc.close();
        int n = s[0].length();
        int m = Integer.parseInt(s[1]);
        StringBuilder[] lines = new StringBuilder[m];
        for (int i = 0; i < m; i++) {
            lines[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i += 2 * m) {
            int index = 0;
            for (int j = 0; j < m; j++) {
                if(i + index < n) lines[j].append(s[0].charAt(i + index));
                index++;
            }
            for (int j = m - 1; j >= 0; j--) {
                if(i + index < n) lines[j].append(s[0].charAt(i + index));
                index++;
            }
        }
        for (StringBuilder line : lines) {
            System.out.println(line);
        }
    }
}
