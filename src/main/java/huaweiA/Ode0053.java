package huaweiA;

import java.util.*;

public class Ode0053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        HashMap< Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int pos = sc.nextInt();
            int dis = sc.nextInt();
            map.put(pos, i);
            distance[0][i] = dis;
            distance[i][0] = dis;
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int pos = sc.nextInt();
            int dis = sc.nextInt();
            distance[map.get(start)][map.get(pos)] = dis;
            distance[map.get(pos)][map.get(start)] = dis;
        }
        for (int i = 0; i < n + 1; i++) distance[i][i] = 0;
        // floyd
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        int[][] dp = new int[1 << (n + 1)][n + 1];
        for (int i = 0; i < 1 << (n + 1); i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[1][0] = 0;

        for (int state = 1; state < (1 << (n + 1)); state++) {
            // state表示二进制数位上的位置是否去过 1为去过 0为没去过
            for (int j = 0; j <= n; j++) {
                // 更新每一个（当前状态到达过，且可达）的点，到所有点的距离
                if (((state >> j) & 1) == 1 && dp[state][j] != Integer.MAX_VALUE) {
                    for (int last = 0; last <= n; last++) {
                        dp[state | (1 << last)][last] = Math.min(dp[state | (1 << last)][last], dp[state][j] + distance[j][last]);
                    }
                }
            }
        }

        System.out.println(dp[(1 << (n + 1)) - 1][0]);

    }
}
