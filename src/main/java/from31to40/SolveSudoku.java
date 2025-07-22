package from31to40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class SolveSudoku {
    // https://leetcode.cn/problems/sudoku-solver/ 37困难
    // 暴力超时
    public void solveSudoku(char[][] board) {
        HashMap<Integer, Integer>[][] possibility = new HashMap[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                possibility[i][j] = new HashMap<>();
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        possibility[i][j].put(k,1);
                    }
                } else {
                    possibility[i][j].put(board[i][j] - '0',1);
                }
            }
        }
        int[][] filled = new int[9][9];
        boolean finished = IsFinish(possibility);
        while (!finished) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (possibility[i][j].size() == 1) {
                        if (filled[i][j] == 0) {
                            filled[i][j] = 1;
                            int num = possibility[i][j].keySet().iterator().next();
                            for (int k = 0; k < 9; k++) {
                                if (k != j) possibility[i][k].remove(num);
                            }
                            for (int k = 0; k < 9; k++) {
                                if (k != i) possibility[k][j].remove(num);
                            }
                            // 算出属于格子的开头
                            int x = i / 3 * 3;
                            int y = j / 3 * 3;
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 3; l++) {
                                    int curX = x + k;
                                    int curY = y + l;
                                    if (curX != i || curY != j) {
                                        possibility[curX][curY].remove(num);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            finished = IsFinish(possibility);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = possibility[i][j].keySet().iterator().next().toString().charAt(0);
            }
        }
    }
    public boolean IsFinish(HashMap<Integer,Integer>[][] possibility) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (possibility[i][j].size() == 1) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}