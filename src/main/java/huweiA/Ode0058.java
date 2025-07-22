package huweiA;

import java.util.*;

public class Ode0058 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int k = Integer.parseInt(ss[2]);
        sc.close();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int y = i, x = j;
                while (x > 0) {
                    int num = x % 10;
                    x = x / 10;
                    sum += num;
                }
                while (y > 0) {
                    int num = y % 10;
                    y /= 10;
                    sum += num;
                }
                if (sum <= k) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        int res = dfs(new int[] {0,0}, matrix, visited);
        System.out.println(res);
    }

    private static int dfs(int[] Pos, int[][] matrix, boolean[][] visited) {
        if (Pos[0] < 0
                || Pos[0] >= matrix.length
                || Pos[1] < 0
                || Pos[1] >= matrix[0].length
                || visited[Pos[0]][Pos[1]]
                || matrix[Pos[0]][Pos[1]] == 0) {
            return 0;
        }
        visited[Pos[0]][Pos[1]] = true;
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            int x = Pos[0] + move[i][0];
            int y = Pos[1] + move[i][1];
            sum += dfs(new int[] {x, y}, matrix, visited);
        }
        return sum;
    }
}
