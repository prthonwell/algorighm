package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0028 {
    static int[][] offset = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1},{-1,1},{-1,-1},{1,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || matrix[i][j] == 0) continue;
                res++;
                dfs(i,j,visited,matrix);
            }
        }
        System.out.println(res);
    }

    private static void dfs(int x, int y, boolean[][] visited, int[][] matrix) {
        if (x < 0 || x > matrix.length - 1
                || y < 0 || y > matrix[0].length - 1
                || visited[x][y] || matrix[x][y] == 0) return;
        visited[x][y] = true;
        for (int[] offset : offset) {
            int a = x + offset[0];
            int b = y + offset[1];
            dfs(a, b, visited, matrix);
        }
    }
}
