package huweiA;

import java.util.*;

public class Ode0008 {

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<HashSet<Integer>> list = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            List<Integer> cur = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toList();
            list.add(new HashSet<>(cur));
        }
        sc.close();
        int[][] dp = new int[n][n];
        Queue<HashSet<Integer>> q = new LinkedList<>();
        for ( int i = 0; i < n; i++ ) {
            for ( int j = i + 1; j < n; j++ ) {
                int res = 0;
                for (Integer cur : list.get(i)) {
                    if (list.get(j).contains(cur)) {
                        res++;
                    }
                }
                dp[i][j] = res;
                dp[j][i] = res;
                if (res >= 2) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    q.add(set);
                }
            }
        }
        while ( !q.isEmpty() ) {
            HashSet<Integer> cur = q.poll();
            boolean flag = false;
            for ( int i = 0; i < list.size(); i++ ) {
                if (cur.contains(i)) continue;
                int same = 0;
                for (Integer cur2 : cur) {
                    same += dp[cur2][i];
                }
                if (same >= 2) {
                    cur.add(i);
                    flag = true;
                }
            }
            if( flag ) {
                q.add(cur);
            }
        }
    }
}