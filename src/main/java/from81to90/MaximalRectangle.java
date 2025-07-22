package from81to90;

class MaximalRectangle {
    // https://leetcode.cn/problems/maximal-rectangle/ 85
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 + dp[i - 1][j] : 0;
            }
        }
        int res = 0;
        int[] stack = new int[n];
        int r = 0, val, Pos;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (r>0 && dp[i][stack[r - 1]] > dp[i][j]) {
                    val = dp[i][stack[--r]];
                    Pos = r > 0 ? stack[r - 1] : -1;
                    res = Math.max(res, val * (j - Pos - 1));
                }
                stack[r++] = j;
            }
            while (r > 0) {
                val = dp[i][stack[--r]];
                Pos = r > 0 ? stack[r - 1] : -1;
                res = Math.max(res, val * (n - Pos - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximalRectangle obj = new MaximalRectangle();
        char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(obj.maximalRectangle(matrix));
    }
}