package from51to60;

import java.util.Arrays;
import java.util.Comparator;

class Merge {
    // https://leetcode.cn/problems/merge-intervals/ 56
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = intervals.length;
        int i = 0;
        int index = 0;
        int add = 1;
        while (i + add < n) {
            int[] a = intervals[index];
            int[] b = intervals[i + add];
            if (a[1] >= b[0]) {
                intervals[index] = new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
                add++;
            }else {
                index++;
                i = add + i;
                add = 1;
                intervals[index] = intervals[i];
            }
        }
        int[][] res = new int[index + 1][2];
        for (int j = 0; j <= index; j++) {
            res[j] = intervals[j];
        }
        return res;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = merge.merge(new int[][]{{0,2},{2,3},{4,4},{0,1},{5,7},{4,5},{0,0}});
    }
}