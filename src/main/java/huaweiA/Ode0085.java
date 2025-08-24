package huaweiA;

import java.util.*;

public class Ode0085 {

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] votes = new int[n][2];
        for (int i = 0; i < n; i++) {
            votes[i][0] = sc.nextInt();
            votes[i][1] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(votes[i][0])) {
                map.put(votes[i][0], map.get(votes[i][0]) + 1);
            } else {
                map.put(votes[i][0], 1);
            }
        }
        backtrace(0, 0, votes, map);
        System.out.println(res);
    }
    private static void backtrace(int index, int cost, int[][] votes, HashMap<Integer, Integer> map) {
        if (check(map)) {
            res = cost;
            return;
        }
        if (cost >= res || index == votes.length) {
            return;
        }
        if (votes[index][0] != 0) {
            map.put(votes[index][0], map.get(votes[index][0]) - 1);
            map.put(0, map.get(0) + 1);
            backtrace(index + 1, cost + votes[index][1], votes, map );
            map.put(0, map.get(0) - 1);
            map.put(votes[index][0], map.get(votes[index][0]) + 1);
        }
        backtrace(index + 1, cost, votes, map);
    }

    private static boolean check(HashMap<Integer, Integer> map) {
        int cur = map.getOrDefault(0, 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() != 0 && entry.getValue() >= cur) {
                return false;
            }
        }
        return true;
    }
}
