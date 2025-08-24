package huaweiB;

import java.util.*;

public class odb0028 {

    static int[][] offset = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == -3) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int[][] dp = new int[n][n];
        dp[start[0]][start[1]] = 2;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1] });
        int[] res = new int[2];
        while (!q.isEmpty()) {
            int l = q.size();
            boolean find = false;
            for (int i = 0; i < l; i++) {
                int[] cur = q.poll();
                if (visited[cur[0]][cur[1]]) continue;
                visited[cur[0]][cur[1]] = true;
                for (int j = 0; j < 4; j++) {
                    int a = cur[0] + offset[j][0];
                    int b = cur[1] + offset[j][1];
                    if (a < 0 || a >= n || b < 0 || b >= n
                            || visited[a][b] || matrix[a][b] == -1) continue;
                    dp[a][b] = Math.max(dp[a][b], dp[cur[0]][cur[1]] + matrix[a][b]);
                    if (matrix[a][b] == -2) {
                        find = true;
                        res[0] = a;
                        res[1] = b;
                    }
                    q.add(new int[] { a, b });
                }
            }
            if (find) {
                System.out.println(dp[res[0]][res[1]]);
                return;
            }
        }
        System.out.println(-1);
    }
}
