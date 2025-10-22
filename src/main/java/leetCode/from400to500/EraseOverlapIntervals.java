package leetCode.from400to500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int n = intervals.length;
        int[][] intervals2 = new int[n][2];
        HashMap<int[], Integer> IndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intervals2[i][0] = intervals[i][0];
            intervals2[i][1] = intervals[i][1];
            IndexMap.put(intervals2[i], i);
        }
        Arrays.sort(intervals2, (a,b) -> a[1] - b[1]);
        int nextIndex = 0;
        int[] nextUnconnected = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals2[i][1];
            while (nextIndex < n && intervals[nextIndex][0] < end) {
                nextIndex++;
            }
            nextUnconnected[IndexMap.get(intervals2[i])] = nextIndex;
        }
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(1 + dp[i + 1], dp[nextUnconnected[i]] + nextUnconnected[i] - i - 1);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2},
                {2, 4},
                {4, 6},
                {1, 8},
        };
        EraseOverlapIntervals er = new EraseOverlapIntervals();
        System.out.println(er.eraseOverlapIntervals(intervals));
    }
}
