package huaweiB;

import java.util.*;

public class ode0159 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt(), end = sc.nextInt();
        sc.close();
        System.out.println(process(end) - process(start - 1));
    }

    private static int process(int end) {
        // 有多少个不含101的数
        List<Integer> nums = Arrays
                .stream(Integer.toBinaryString(end).split(""))
                .map(Integer::parseInt)
                .toList();
        int[][][] dp = new int[nums.size()][2][2];
        return dfs(dp, nums, true, 0,0,0);
    }

    private static int dfs(int[][][] dp, List<Integer> nums, boolean limit, int i, int pre, int prepre) {
        if (i == nums.size()) {
            return 1;
        }
        if (!limit && dp[i][pre][prepre] != 0) return dp[i][pre][prepre];
        int max = limit ? nums.get(i) : 1;
        int count = 0;
        for (int j = 0; j <= max; j++) {
            if (j == 1 && pre == 0 && prepre == 1) continue;
            count += dfs(dp, nums, limit && j == max, i + 1, j, pre);
        }
        if (!limit) dp[i][pre][prepre] = count;
        return count;
    }
}
