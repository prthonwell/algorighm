package huaweiB;

import java.util.*;

public class odb0010 {

    static int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[m][n];
        List<int[]> startPos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 3) {
                    startPos.add(new int[] { i, j });
                }
            }
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill( dp[i], -1);
        for (int[] arr : startPos) {
            if (dp[arr[0]][arr[1]] != -1) continue;
            List<int[]> path = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            int coll = dfs(path, matrix, arr[0], arr[1], visited);
            for (int[] cur : path) {
                dp[cur[0]][cur[1]] = coll;
            }
        }
        int count = 0;
        for (int[] arr : startPos) {
            if (dp[arr[0]][arr[1]] == 2) count++;
        }
        System.out.println(count);
    }

    private static int dfs(List<int[]> path, int[][] matrix, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || visited[x][y] || matrix[x][y] == 1) return 0;
        visited[x][y] = true;
        path.add(new int[] {x, y});
        int coll = 0;
        for (int[] offset : offset) {
            coll += dfs(path, matrix, x + offset[0], y + offset[1], visited);
        }
        return (matrix[x][y] == 2 ? 1 : 0) + coll;
    }
}
