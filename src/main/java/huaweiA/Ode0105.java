package huaweiA;

import java.util.*;

public class Ode0105 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tasks = sc.nextInt(), m = sc.nextInt();
        HashMap< Integer, HashSet<Integer>> relations = new HashMap<>();
        for ( int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            HashSet<Integer> cur = relations.getOrDefault( a, new HashSet<>() );
            cur.add(b);
            relations.put( a, cur );
        }
        dp = new int[tasks];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tasks; i++) {
            dp[i] = count(i, relations);
            max = Math.max(max, dp[i]);
        }
        System.out.println( max );
    }

    private static int count(int i, HashMap< Integer, HashSet<Integer>> relations) {
        if (dp[i] != 0) return dp[i];
        if (!relations.containsKey(i)) {
            return 1;
        } else {
            HashSet<Integer> cur = relations.get( i );
            int max = Integer.MIN_VALUE;
            for (Integer b : cur) {
                dp[b] = count(b, relations);
                max = Math.max(dp[b] + 1, max);
            }
            return max;
        }
    }
}
