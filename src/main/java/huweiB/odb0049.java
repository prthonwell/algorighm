package huweiB;

import java.util.*;

public class odb0049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] board = new int[n][m];
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        int[] indexes = new int[m];
        Arrays.fill( indexes, n - 1 );
        int adder = 1, index = 0, cur = 1, N = line.length;
        out: while (index < N) {
            int[][] temp = new int[n][m];
            int[] tempIndexes = Arrays.copyOf( indexes, indexes.length );
            int tempIndex = index;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = board[i][j];
                }
            }
            for (int i = 0; i < adder && index + i < N; i++) {
                if (!put(board, line, index+i, indexes)) {
                    System.out.println( (index + i + 1) + "," + "error");
                    return;
                }
            }
            index = Math.min(index + adder, N);
            adder <<= 1;
            if (index < 7) {
                continue;
            }
            int countOne = 0, countTwo = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1) {
                        countOne++;
                        countTwo = 0;
                    } else if (board[i][j] == 2) {
                        countTwo++;
                        countOne = 0;
                    } else {
                        countOne = 0;
                        countTwo = 0;
                    }
                    if (countOne == 4 || countTwo == 4) {
                        if (adder == 2) {
                            String res = index % 2 == 1 ? "red" : "blue";
                            System.out.println(index + "," + res);
                            return;
                        } else {
                            board = temp;
                            index = tempIndex;
                            indexes = tempIndexes;
                            adder = 1;
                            continue out;
                        }
                    }
                }
            }
            countOne = 0; countTwo = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] == 1) {
                        countOne++;
                        countTwo = 0;
                    } else if (board[j][i] == 2) {
                        countTwo++;
                        countOne = 0;
                    } else {
                        countOne = 0;
                        countTwo = 0;
                    }
                    if (countOne == 4 || countTwo == 4) {
                        if (adder == 2) {
                            String res = index % 2 == 1 ? "red" : "blue";
                            System.out.println(index + "," + res);
                            return;
                        } else {
                            board = temp;
                            index = tempIndex;
                            indexes = tempIndexes;
                            adder = 1;
                            continue out;
                        }
                    }
                }
            }
            countOne = 0; countTwo = 0;
            for (int offset = n - 4; offset >= -(m - 4); offset--) {
                for (int i = Math.max(0, -offset); i + offset < n && i < m; i++) {
                    if (board[i + offset][i] == 1) {
                        countOne++;
                        countTwo = 0;
                    } else if (board[i + offset][i] == 2) {
                        countTwo++;
                        countOne = 0;
                    } else {
                        countOne = 0;
                        countTwo = 0;
                    }
                    if (countOne == 4 || countTwo == 4) {
                        if (adder == 2) {
                            String res = index % 2 == 1 ? "red" : "blue";
                            System.out.println(index + "," + res);
                            return;
                        } else {
                            board = temp;
                            index = tempIndex;
                            indexes = tempIndexes;
                            adder = 1;
                            continue out;
                        }
                    }
                }
            }
            countOne = 0; countTwo = 0;
            for (int sum = 3; sum <= m - 1; sum++) {
                for (int i = Math.min(n - 1, sum); i >= 0 && (sum - i) < m; i--) {
                    if (board[i][sum - i] == 1) {
                        countOne++;
                        countTwo = 0;
                    } else if (board[i][sum - i] == 2) {
                        countTwo++;
                        countOne = 0;
                    } else {
                        countOne = 0;
                        countTwo = 0;
                    }
                    if (countOne == 4 || countTwo == 4) {
                        if (adder == 2) {
                            String res = index % 2 == 1 ? "red" : "blue";
                            System.out.println(index + "," + res);
                            return;
                        } else {
                            board = temp;
                            index = tempIndex;
                            indexes = tempIndexes;
                            adder = 1;
                            continue out;
                        }
                    }
                }
            }
        }
        System.out.println(0 + "," + "draw");
        sc.close();
    }

    private static boolean put(int[][] board, String[] line, int index, int[] indexes) {
        int pos = Integer.parseInt(line[index]) - 1;
        if ( pos < 0 || pos >= board[0].length || indexes[pos] < 0 || indexes[pos] >= board.length) return false;
        board[indexes[pos]][pos] = index % 2 == 0 ? 1 : 2; // 1 red 2 blue
        indexes[pos]--;
        return true;
    }

}
