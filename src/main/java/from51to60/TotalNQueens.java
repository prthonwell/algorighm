package from51to60;

class TotalNQueens {
    private class Count {
        int count;

        public Count(int count) {
            this.count = count;
        }
    }
    // https://leetcode.cn/problems/n-queens-ii/ 52
    public int totalNQueens(int n) {
        Count count = new Count(0);
        process(count, 0, n, 0, 0, 0);
        return count.count;
    }

    private void process(Count count, int row, int n, int col, int left, int right) {
        if (row == n) {
            count.count++;
        } else {
            int availablePos = ~(col | left | right) & ((1 << n) - 1);
            while (availablePos != 0) {
                int pos = availablePos & (-availablePos);
                availablePos = availablePos & (availablePos - 1);
                process(count, row + 1, n , col | pos, (left | pos) << 1, (right | pos) >> 1);
            }
        }
    }
}