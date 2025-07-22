package huweiA;

import java.util.*;

public class Ode0057Plus {
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
        HashMap< Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        sc.close();
        HashMap< Integer, Integer>[][] MatrixMap = new HashMap[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            MatrixMap[i][i] = new HashMap<>();
            if (i != m) {
                HashMap< Integer, Integer> cur = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    int num = matrix[j][i];
                    if (map.containsKey(num)) {
                        cur.put(num, cur.getOrDefault(num, 0) + 1);
                    }
                }
                boolean flag = true;
                for (Integer key : map.keySet()) {
                    int num = cur.getOrDefault(key, 0);
                    if (num < map.get(key)) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(1);
                }
                MatrixMap[i][i + 1] = cur;
            }
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j + i <= m; j++) {
                HashMap< Integer, Integer> cur = new HashMap<>();
                HashMap< Integer, Integer> pre = MatrixMap[j][j + i - 1];
                HashMap< Integer, Integer> c = MatrixMap[j + i - 1][j + i];
                boolean flag = true;
                for (Integer key : map.keySet()) {
                    int num = pre.getOrDefault(key, 0) + c.getOrDefault(key, 0);
                    cur.put(key, num);
                    if (num < map.get(key)) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(i);
                    return;
                }
                MatrixMap[j][j + i] = cur;
            }
        }
        System.out.println(-1);
    }
}
