package huaweiB;

import java.util.*;

public class odb0011 {

    static int[][] offset = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        matrix[0][0] = 0;
        int coll = dfs(matrix, 0, 0, new boolean[m][n]);
        System.out.println(n*m - coll);
    }

    private static int dfs(int[][] matrix, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || visited[x][y] || matrix[x][y] == 2) return 0;
        visited[x][y] = true;
        int coll = 1;
        for (int[] offset : offset) {
            coll += dfs(matrix, x + offset[0], y + offset[1], visited);
        }
        return coll;
    }
}
