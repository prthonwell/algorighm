package huweiA;

import java.util.*;

public class Ode0057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int len = sc.nextInt();
        HashMap<Integer, Integer> PosMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = sc.nextInt();
            PosMap.put(num, PosMap.getOrDefault(num, 0) + 1);
        }
        sc.close();

        int l = 0, r = 0, min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> cur = new HashMap<>();

        while (r < m) {
            for (int j = 0; j < n; j++) {
                int num = matrix[j][r];
                if (PosMap.containsKey(num)) {
                    cur.put(num, cur.getOrDefault(num, 0) + 1);
                }
            }
            boolean flag = true;
            for (Integer key : PosMap.keySet()) {
                if (cur.getOrDefault(key, 0) < PosMap.get(key)) flag = false;
            }
            while (flag) {
                min = Math.min(min, r - l + 1);
                if (min == 1) {
                    System.out.println(1);
                    return;
                }
                for (int j = 0; j < n; j++) {
                    int num = matrix[j][l];
                    if (PosMap.containsKey(num)) {
                        cur.put(num, cur.get(num) - 1);
                    }
                }
                for (Integer key : PosMap.keySet()) {
                    if (cur.getOrDefault(key, 0) < PosMap.get(key)) flag = false;
                }
                l++;
            }
            r++;
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
