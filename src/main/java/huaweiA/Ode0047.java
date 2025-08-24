package huaweiA;

import java.util.*;

public class Ode0047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        int l = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        if (l < 0) l = 0;
        if (r >= n) r = n - 1;
        if (r <= l) {
            System.out.println(s);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == l) {
                for (int j = r; j >= l; j--) {
                    sb.append(ss[j]).append(" ");
                }
                i = r;
                continue;
            }
            sb.append(ss[i]).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
