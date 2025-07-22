package leetCode.from31to40;

import java.util.ArrayList;

class SolveSudoku2 {
    // https://leetcode.cn/problems/sudoku-solver/ 37困难
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];
    ArrayList<int[]> empty = new ArrayList<>();
    boolean flag = false; // 标记是否找到解，找到解后终止递归
    // 递归全排列
    public void solveSudoku(char[][] board) {

        // 检查记录所有空位置
        // 收集行内剩余数
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = board[i][j] - '1';
                if (board[i][j] == '.') {
                    empty.add(new int[]{i, j});
                } else {
                    rows[i][index] = true;
                    cols[j][index] = true;
                    boxes[i / 3][j / 3][index] = true;
                }
            }
        }
        // 深度优先全排列
        dfs(board, 0);
    }

    public void dfs(char[][] board, int index) {
        if (index == empty.size()) {
            flag = true;
            return;
        }
        int[] pos = empty.get(index);
        int row = pos[0], col = pos[1];
        for (int i = 0; i < 9 && !flag; i++) {
            if (!rows[row][i] && !cols[col][i] && !boxes[row / 3][col / 3][i]) {
                board[row][col] = (char) (i + '1');
                rows[row][i] = cols[col][i] = boxes[row / 3][col / 3][i] = true;
                dfs(board, index + 1);
                rows[row][i] = cols[col][i] = boxes[row / 3][col / 3][i] = false;
            }
        }
    }

}