package huaweiB;

import java.util.*;

public class odb0026 {

    static int[][] offset = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static String[] direction = new String[] {"S","N","E","W"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turns = sc.nextInt(), crosses = sc.nextInt();
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] matrix = new char[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String ss = sc.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ss.charAt(j);
                if (matrix[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        sc.close();
        for (int i = 0; i < 4; i++) {
            int a = start[0] + offset[i][0];
            int b = start[1] + offset[i][1];
            boolean[][] visited = new boolean[n][m];
            if (dfs(a,b,matrix,visited,turns,crosses,direction[i])) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean dfs(int x, int y, char[][] matrix, boolean[][] visited, int turns, int crosses, String direct) {
        if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || visited[x][y] || turns < 0) {
            return false;
        }
        visited[x][y] = true;
        if (matrix[x][y] == 'T') return true;
        if (matrix[x][y] == '*') {
            crosses--;
            if (crosses < 0) return false;
        }
        for (int i = 0; i < 4; i++) {
            int a = x + offset[i][0];
            int b = y + offset[i][1];
            if (!direction[i].equals(direct)) {
                if (dfs(a, b, matrix, visited, turns - 1, crosses, direction[i])) return true;
            } else {
                if (dfs(a, b, matrix, visited, turns, crosses, direction[i])) return true;
            }
        }
        return false;
    }
}
