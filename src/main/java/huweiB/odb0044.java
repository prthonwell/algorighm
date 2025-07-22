package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0044 {
    static int[][] offset = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 2);
        map.put(1, 3);
        map.put(2, 1);
        map.put(3, 0);
    }
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
        int perRoad = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        int[][] dp = new int[n][m]; // 带状态的dp不能只是简单的更新值
        int[][][] dpW = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int[] a : dpW[i]) {
                Arrays.fill(a, 100000);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startX, startY, -1, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = pos[0] + offset[i][0];
                    int y = pos[1] + offset[i][1];
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    int cost = pos[3] + perRoad;
                    if (pos[2] != -1 && (map.get(pos[2]) == i || pos[2] == i))
                        cost += matrix[pos[0]][pos[1]];
                    if (cost < dpW[x][y][i]) {
                        dpW[x][y][i] = cost;
                        q.add(new int[] { x, y, i, cost});
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4;i++) {
            res = Math.min(res, dpW[endX][endY][i]);
        }
        System.out.println(res);
        sc.close();
    }
}
