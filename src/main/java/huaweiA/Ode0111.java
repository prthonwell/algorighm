package huaweiA;

import java.util.*;

public class Ode0111 {

    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        Queue<int[]> changed = new LinkedList<>();
        changed.add(new int[] {0,0});
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = matrix[0][0];
        while (!changed.isEmpty()) {
            int[] cur = changed.poll();
            for (int[] move : move) {
                int a = cur[0] + move[0];
                int b = cur[1] + move[1];
                if (a < 0 || a >= M || b < 0 || b >= N) continue;
                int cost = dp[cur[0]][cur[1]] + matrix[a][b];
                if (matrix[a][b] == matrix[cur[0]][cur[1]] && matrix[a][b] >= 1) {
                    cost--;
                }
                if (cost < dp[a][b]) {
                    dp[a][b] = cost;
                    changed.add(new int[] {a,b});
                }
            }

        }
        System.out.println(dp[M - 1][N - 1]);
    }

}
