package from121to140;

class CanCompleteCircuit {
    // https://leetcode.cn/problems/gas-station/ 134
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = gas[i] - cost[i];
        }
        int min = Integer.MAX_VALUE;
        int c = 0;
        for (int i = 0; i < n; i++) {
            c += arr[i];
            min = Math.min(min, c);
        }
        if (c < 0) return -1;
        if (min >= 0) return 0;
        for (int i = 0; i < n; i++) {
            min -= arr[i];
            if (min >= 0) {
                return i + 1;
            }
        }
        return -1;
    }
}