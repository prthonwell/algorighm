package huaweiB;

import java.util.*;

public class ode0023 {

    static int[] mins = new int[] {0, 10, 100, 1000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int m = sc.nextInt();
        int k = n / m;
        if (n % m != 0) {
            int dif = (k + 1) * m - n;
            System.out.println(mins[k] - dif);
            return;
        }
        int[] spec = new int[10];
        for (int i = 0; i < n; i++) {
            spec[s.charAt(i) - '0']++;
        }
        out: for (int i = mins[k - 1]; i < mins[k] - m + 1; i++) {
            int[] curSpec = new int[10];
            for (int j = i; j < i + m; j++) {
                int cur = j;
                while (cur > 0) {
                    curSpec[cur % 10]++;
                    if (curSpec[cur % 10] > spec[cur % 10]) {
                        continue out;
                    }
                    cur /= 10;
                }
            }
            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                if (curSpec[j] != spec[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                return;
            }
        }
    }
}
