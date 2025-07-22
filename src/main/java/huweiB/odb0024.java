package huweiB;

import java.util.*;

public class odb0024 {

    static int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0 && !visited[i][j]) {
                    ans = Math.max(ans, dfs(i,j,matrix,visited));
                }
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int x, int y, int[][] matrix, boolean[][] visited) {
        if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1
                || visited[x][y] || matrix[x][y] == 0) {
            return 0;
        }
        visited[x][y] = true;
        int res = matrix[x][y];
        for (int[] ints : offset) {
            int a = x + ints[0];
            int b = y + ints[1];
            res += dfs(a, b, matrix, visited);
        }
        return res;
    }
}
