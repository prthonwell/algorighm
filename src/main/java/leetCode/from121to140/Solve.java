package leetCode.from121to140;

class Solve {
    public void solve(char[][] board) {
        int bottom = board.length;
        int right = board[0].length;
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, right - 1);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            dfs(board, 0, i);
            dfs(board, bottom - 1, i);
        }
        for (int i = 0; i < bottom; i++) {
            for (int j = 0; j < right; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[] b1 = {'X','X','X','X'};
        char[] b2 = {'X','O','O','X'};
        char[] b3 = {'X','X','O','X'};
        char[] b4 = {'X','O','X','X'};
        char[][] board = {b1,b2,b3,b4};
        Solve solve = new Solve();
        solve.solve(board);
    }
}