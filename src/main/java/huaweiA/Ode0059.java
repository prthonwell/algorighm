package huaweiA;

import java.util.*;

public class Ode0059 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                int cur = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    int a = i + move[k][0];
                    int b = j + move[k][1];
                    if (a < 0 || a >= matrix.length
                            || b < 0 || b >= matrix[0].length
                            || matrix[a][b] == cur) continue;
                    int num = matrix[a][b];
                    dfs(list, new int[] {a, b}, matrix, visited, 1, num > cur);
                }
                visited[i][j] = false;
            }
        }

        System.out.println(list.get(0));
    }

    private static void dfs(List<Integer> list, int[] pos, int[][] matrix, boolean[][] visited, int path, boolean isUp) {
        if (path > list.get(0)) {
            list.remove(0);
            list.add(path);
        }
        int cur = matrix[pos[0]][pos[1]];
        visited[pos[0]][pos[1]] = true;
        for (int i = 0; i < 4; i++) {
            int a = pos[0] + move[i][0];
            int b = pos[1] + move[i][1];
            int num;
            if (a < 0 || a >= matrix.length
                    || b < 0 || b >= matrix[0].length
                    || visited[a][b]
                    || (num = matrix[a][b]) == matrix[pos[0]][pos[1]]
                    || isUp ^ num < cur) continue;
            dfs(list, new int[] {a, b}, matrix, visited, path + 1, !isUp);
        }
        visited[pos[0]][pos[1]] = false;
    }
}
