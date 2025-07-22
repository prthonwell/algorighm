package huweiA;

import java.util.*;

public class Ode0049 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        List<int[]> starts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 1) {
                    starts.add(new int[] { i, j });
                }
            }
        }
        matrix[0][0] = 1;
        starts.add(new int[] { 0, 0 });
        int c = starts.size();
        for (int i = 0; i < c; i++) {
            int[] arr = starts.get(i);
            for (int j = 0; j < 4; j++) {
                int n1 = move[j][0] + arr[0];
                int m1 = move[j][1] + arr[1];
                dfs(new int[] {n1, m1}, matrix, starts);
            }
        }
        System.out.println( n * m - starts.size());
    }

    private static void dfs(int[] start, int[][] matrix, List<int[]> visited) {
        if (start[0] < 0 ||
                start[0] >= matrix.length ||
                start[1] >= matrix[0].length ||
                start[1] < 0 ||
                matrix[start[0]][start[1]] == 2 ||
                matrix[start[0]][start[1]] == 1
        ) {
            return;
        }
        matrix[start[0]][start[1]] = 1;
        visited.add(new int[] {start[0], start[1]});
        for (int i = 0; i < 4; i++) {
            int n = move[i][0] + start[0];
            int m = move[i][1] + start[1];
            dfs(new int[] {n,m}, matrix, visited);
        }
    }
}
