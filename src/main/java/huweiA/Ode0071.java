package huweiA;

import java.util.*;

public class Ode0071 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String mustGo = sc.nextLine();
        sc.close();
        int n = mustGo.length();
        int m = s.length();
        int[] spec = new int[26];
        for (int i = 0; i < n; i++) {
            spec[mustGo.charAt(i) - 'A']++;
        }
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (spec[s.charAt(i) - 'A'] > 0) {
                List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
                list.add(i);
                map.put(s.charAt(i), list);
                if (list.size() > max) {
                    max = list.size();
                }
            }
        }
        int[][] dp = new int[n + 1][max];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = n - 1; i>= 0; i--) {
            if (i == 0) {
                int index2 = 0;
                for (Integer PrePos : map.get(mustGo.charAt(i))) {
                    dp[i][0] = Math.min(dp[i][0], PrePos + dp[i + 1][index2]);
                    index2++;
                }
                continue;
            }
            int index = 0;
            for (Integer pos : map.get(mustGo.charAt(i - 1))) {
                int index2 = 0;
                for (Integer PrePos : map.get(mustGo.charAt(i))) {
                    dp[i][index] = Math.min(dp[i][index], Math.abs(pos - PrePos) + dp[i + 1][index2]);
                    index2++;
                }
                index++;
            }
        }
        for (int i = 0; i < map.get(mustGo.charAt(0)).size(); i++) {

        }
        System.out.println(dp[0][0]);
    }
}
