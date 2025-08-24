package leetCode.from71to80;

class Exist {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int l = word.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dp[i][j] = 1; // 可以直接在原数组上记录的
                    boolean res = dfsWithDp(1, i, j, word, l, dp, n, m, board);
                    if (res) return true;
                    dp[i][j] = 0;
                }
            }
        }
        return false;
    }
    public boolean dfsWithDp(int cur, int i, int j, String word, int l, int[][] dp, int n, int m, char[][] board) {
        if (cur == l) {
            return true;
        }else {
            if (i > 0
                    && dp[i - 1][j] == 0
                    && board[i - 1][j] == word.charAt(cur)
            ) {
                dp[i - 1][j] = 1;
                boolean res = dfsWithDp(cur + 1, i - 1, j, word, l, dp, n, m, board);
                if (res) return true;
                dp[i - 1][j] = 0;
            }
            if (i < n - 1 && dp[i + 1][j] == 0 && board[i + 1][j] == word.charAt(cur)
            ) {
                dp[i + 1][j] = 1;
                boolean res = dfsWithDp(cur + 1, i + 1, j, word, l, dp, n, m, board);
                if (res) return true;
                dp[i + 1][j] = 0;
            }
            if (j < m - 1 && dp[i][j + 1] == 0 && board[i][j + 1] == word.charAt(cur)
            ) {
                dp[i][j + 1] = 1;
                boolean res = dfsWithDp(cur + 1, i, j + 1, word, l, dp, n, m, board);
                if (res) return true;
                dp[i][j + 1] = 0;
            }
            if (j > 0 && dp[i][j - 1] == 0 && board[i][j - 1] == word.charAt(cur)
            ) {
                dp[i][j - 1] = 1;
                boolean res = dfsWithDp(cur + 1, i, j - 1, word, l, dp, n, m, board);
                if (res) return true;
                dp[i][j - 1] = 0;
            }
        }
        return false;
    }
}