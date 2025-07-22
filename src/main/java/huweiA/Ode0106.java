package huweiA;

import java.util.*;

public class Ode0106 {
    static class city {
        int id;
        List<Integer> connected;
        city( int id ) {
            this.id = id;
            connected = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        city[] cities = new city[num + 1];
        for ( int i = 1; i <= num; i++ ) {
            cities[i] = new city( i );
        }
        for ( int i = 0; i < num - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            cities[a].connected.add(b);
            cities[b].connected.add(a);
        }
        int[] dps = new int[num + 1]; // 每个城市清除后最大集中度
        int min = Integer.MAX_VALUE;
        for ( int i = 1; i <= num; i++ ) { //
            int[] dp = new int[num + 1];
            int max = Integer.MIN_VALUE;
            for ( int j = 1; j <= num; j++ ) {
                if (j == i) continue;
                if (dp[j] != 0) continue;
                HashSet<Integer> connected = new HashSet<>();
                connected.add(j);
                Search(connected, cities[j], i, cities);
                int n = connected.size();
                for (Integer k : connected) {
                    dp[k] = n;
                }
                max = Math.max(max, n);
            }
            dps[i] = max;
            min = Math.min(min, dps[i]);
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 1; i < num + 1; i++ ) {
            if (dps[i] == min) {
                sb.append( i ).append(" ");
            }
        }

        System.out.println( sb.substring( 0, sb.length() - 1 ) );
    }

    private static void Search(HashSet<Integer> connected, city city, int i, city[] cities) {
        for (Integer j : city.connected) {
            if (j == i) continue;
            if (connected.contains(j)) continue;
            connected.add(j);
            Search(connected, cities[j], i, cities);
        }
    }


}
