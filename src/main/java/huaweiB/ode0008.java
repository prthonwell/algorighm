package huaweiB;

import java.util.*;

public class ode0008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream( sc.nextLine().split(" ")).mapToInt( Integer::parseInt ).toArray();
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], 10000);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = sum[j] - sum[i] + arr[i];
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int offset = n - 1; offset >= 0; offset--) {
            boolean found = false;
            for (int i = 0; i < n && i + offset < n; i++) {
                if (dp[i][i + offset] <= limit * (offset + 1)) {
                    found = true;
                    result.add(new int[]{i, i + offset});
                }
            }
            if (found) break;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int[] a : result) {
            sj.add(a[0] + "-" + a[1]);
        }
        System.out.println(sj.toString());
        sc.close();
    }
}
