package huweiA;

import java.util.HashMap;
import java.util.Scanner;

public class Ode0042 {
    static int[] move = new int[] { 1, 3 };
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        String all = null, used = null;
        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt( i );
            if (c == '@') {
                if ( i != s.length() - 1 ) {
                    used = s.substring( i + 1 );
                }
                all = s.substring(0, i);
            }
        }
        sc.close();
        if (all == null) return;
        if (used == null) {
            System.out.println(all);
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        String[] useds = used.split(",");
        for (int i = 0; i < useds.length; i++) {
            String[] cur = useds[i].split(":");
            map.put(cur[0], map.getOrDefault(cur[0], 0) - Integer.parseInt(cur[1]));
        }
        String[] alls = all.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < alls.length; i++) {
            String[] cur = alls[i].split(":");
            int num = map.getOrDefault(cur[0], 0) + Integer.parseInt(cur[1]);
            if (num == 0) continue;
            sb.append(cur[0]).append(":");
            sb.append(num).append(",");
        }
        if (!sb.isEmpty()) System.out.println(sb.substring(0, sb.length() - 1));
    }
}
