package leetCode.from51to60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolveNQueens {
    public static List<List<String>> solveNQueens(int n) {
        int left = 0;
        int right = 0;
        int col = 0;
        List<List<String>> res = new ArrayList<>();
        process(0, res, n, new ArrayList<Integer>(), left, right, col);
        return res;
    }

    private static void process(int row, List<List<String>> res, int n, ArrayList<Integer> path, int left, int right, int col) {
        if (row == n) {
            List<String> ans = new ArrayList<>();
            for (int pos : path) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[pos] = 'Q';
                ans.add(String.valueOf(chars));
            }
            res.add(ans);
            return;
        }
        int availablePositions = ~(col | left | right) & ((1 << n) - 1);
        while (availablePositions != 0) {
            int i = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            path.add(Integer.bitCount(i - 1));
            process(row + 1, res, n, path, (left | i) << 1, (right | i) >> 1, col | i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public List<List<String>> solveNQueens2(int n) {
        List<int[]> poses = new ArrayList<int[]>();
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        process(poses, 0, res, n);
        List<List<String>> res2 = new ArrayList<>();
        for (int k = 0; k < res.size(); k++) {
            List<String> cur = new ArrayList<>();
            for (int[] pos : res.get(k)) {
                int i = pos[1];
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                cur.add(String.valueOf(chars));
            }
            res2.add(cur);
        }
        return res2;
    }

    private void process(List<int[]> poses, int row, List<List<int[]>> res ,int n) {
        if (n == row) {
            res.add(new ArrayList<>(poses));
        }
        for (int i = 0; i < n; i++) {
            if(isGood(poses, row, i)) {
                int[] pos = new int[]{row, i};
                poses.add(pos);
                process(poses, row + 1, res, n);
                poses.remove(poses.size() - 1);

            }
        }
    }
    private boolean isGood(List<int[]> poses, int row, int col) {
        for (int[] pos : poses) {
            if (pos[0] == row || pos[1] == col || row - col == pos[0] - pos[1] || row + col == pos[0] + pos[1]) {
                return false;
            }
        }
        return true;
    }
}