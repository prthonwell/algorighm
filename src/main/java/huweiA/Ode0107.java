package huweiA;

import java.util.*;

public class Ode0107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ,time = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int[] cross = new int[n];
        for (int i = 0; i < n; i++) {
            cross[i] = Integer.parseInt(ss[i]);
        }
        sc.close();
        Arrays.sort(cross);
        int[] dp = new int[3];
        dp[0] = cross[0];
        if (dp[0] > time) {
            System.out.println("0 0");
            return;
        }
        dp[1] = get(cross[0], cross[1]);
        if (dp[1] > time) {
            System.out.println("1 " + dp[1]);
        }
        int i = 2;
        for (; i < n; i++) {
             dp[2] = dp[1] + cross[0] + get(cross[0], cross[i]);
             if (i >= 3) {
                 int m2 = dp[0] + cross[0] + get(cross[i - 1], cross[i]) + cross[1] + get(cross[0], cross[1]);
                 dp[2] = Math.min(dp[2], m2);
             }
             if (dp[2] > time) {
                 System.out.println(i + " " + dp[1]);
                 return;
             } else if (dp[2] == time) {
                 System.out.println(i + 1 + " " + dp[2]);
                 return;
             }
             dp[0] = dp[1];
             dp[1] = dp[2];
        }
        System.out.println(n + " " + dp[2]);
    }

    private static int get(int small, int big) {
        return Math.min(small * 10, big);
    }
}
