package leetCode.from51to60;

class Insert {
    // https://leetcode.cn/problems/insert-interval/ 57
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            i++;
        }
        if (i == intervals.length) {
            int[][] res = new int[intervals.length + 1][2];
            int index = 0;
            for (i = 0; i < intervals.length; i++) {
                res[index++] = intervals[i];
            }
            res[index] = newInterval;
            return res;
        }
        if (newInterval[1] < intervals[i][0]) {
            int[][] res = new int[intervals.length + 1][2];
            int index = 0;
            for (int j = 0; j < intervals.length; j++) {
                if (index != i) {
                    res[index++] = intervals[j];
                } else {
                    res[index++] = newInterval;
                    res[index++] = intervals[j];
                }
            }
            return res;
        } else {
            intervals[i] = new int[]{
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])
            };
            int count = 0;
            while (i + count + 1 < intervals.length && intervals[i][1] >= intervals[i + count + 1][0]) {
                intervals[i] = new int[]{
                        intervals[i][0],
                        Math.max(intervals[i][1], intervals[i + count + 1][1])
                };
                count++;
            }
            int[][] res = new int[intervals.length - count][2];
            int index = 0;
            for (int j = 0; j < intervals.length; j++) {
                if (index != i) {
                    res[index++] = intervals[j];
                } else {
                    res[index++] = intervals[j];
                    j += count;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] intervals = new int[][]{{1,3}, {5,9}};
        int[] newInterval = new int[]{2,6};
        int[][] res = insert.insert(intervals, newInterval);
    }
}