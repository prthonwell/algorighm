package huaweiB;

import java.util.*;

public class ode0003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int n = sc.nextInt();
        int len = ss.length;
        int[][] lr = new int[len][2];
        for ( int i = 0; i < len; i++ ) {
            if ( ss[i].contains("-")) {
                String[] sss = ss[i].split("-");
                lr[i][0] = Integer.parseInt(sss[0]);
                lr[i][1] = Integer.parseInt(sss[1]);
            } else {
                lr[i][0] = Integer.parseInt(ss[i]);
                lr[i][1] = -1;
            }
        }
        Arrays.sort(lr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < len; i++ ) {
            int l = lr[i][0];
            if ( lr[i][1] != -1 ) {
                int r = lr[i][1];
                if (l <= n && n <= r) {
                    if (n - l == 1) {
                        sb.append(l).append(",");
                    } else if (n - l > 1) {
                        sb.append(l).append("-").append(n - 1).append(",");
                    }
                    if (r - n == 1) {
                        sb.append(r).append(",");
                    } else if (r - n > 1) {
                        sb.append(n + 1).append("-").append(r).append(",");
                    }
                } else {
                    sb.append(l).append("-").append(r).append(",");
                }
            } else {
                if (l != n) sb.append(l).append(",");
            }
        }
        if (!sb.isEmpty()) {
            System.out.println( sb.substring(0, sb.length() - 1));
        }
        sc.close();
    }
}
