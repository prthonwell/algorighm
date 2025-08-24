package huaweiB;

import java.util.*;

public class odb0052 {

    static int[][] offset = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int times = 0;
        int[] res = new int[2];
        res[1] = board[0][0];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] offset : offset) {
                    int a = x + offset[0], b = y + offset[1];
                    if (a < 0 || a >= board.length
                            || b < 0 || b >= board[0].length
                            || visited[a][b]) continue;
                    if (Math.abs(board[a][b] - board[x][y]) <= k) {
                        queue.add(new int[] {a, b});
                        visited[a][b] = true;
                        if (board[a][b] > res[1]) {
                            res[1] = board[a][b];
                            res[0] = times;
                        }
                    }
                }
            }
        }
        System.out.println(res[1] + " " + res[0]);
        sc.close();
    }
}
