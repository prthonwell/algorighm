package leetCode.from31to40;

class IsValidSudoku {
    // https://leetcode.cn/problems/valid-sudoku/ 36
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i][index]++;
                    cols[j][index]++;
                    boxes[boxIndex][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || boxes[boxIndex][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}