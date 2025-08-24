package huaweiB;

import java.util.*;

public class odb0047 {

    static int[][] offset = new int[][] {{1,0},{0,1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt();
        int[][] board = new int[Y][X]; // 0 未到达 1 墙 2 已到达 3 可以到出口
        board[Y - 1][X - 1] = 3;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            board[x][y] = 1;
        }
        dfs(board, 0, 0);
        int B = 0, A = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] == 0) {
                    A++;
                } else if (board[i][j] == 2) {
                    B++;
                }
            }
        }
        System.out.println(B + " " + A);
        sc.close();
    }

    private static int dfs(int[][] board, int x, int y) {
        if (x < 0 || x >= board.length
                || y < 0 || y >= board[0].length
                || board[x][y] == 1) return 1;
        if (board[x][y] != 0) return board[x][y];
        board[x][y] = 2;
        for (int[] offset : offset) {
            if (dfs(board, x + offset[0], y + offset[1]) == 3) board[x][y] = 3;
        }
        return board[x][y];
    }
}
