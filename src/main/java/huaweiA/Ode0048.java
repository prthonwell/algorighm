package huaweiA;

import java.util.*;

public class Ode0048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        sc.close();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            char c = ss[i].charAt(ss[i].length() - 1);
            int num = Integer.parseInt(ss[i].substring(0, ss[i].length() - 1));
            if (c == 'Y') {
                prices[i] = num;
            } else {
                prices[i] = num * 7;
            }
        }
        int[] cur = new int[2]; // have, dont have
        cur[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            int num0 = Math.max(cur[1] - prices[i], cur[0]);
            int num1 = Math.max(cur[0] + prices[i], cur[1]);
            cur[0] = num0;
            cur[1] = num1;
        }
        System.out.println(Math.max(cur[1], cur[0]));
    }
}
