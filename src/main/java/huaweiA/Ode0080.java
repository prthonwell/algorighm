package huaweiA;

import java.util.*;

public class Ode0080 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minLen = sc.nextInt();
        sc.nextLine();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        sc.close();
        double[] dp = new double[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        double sum = 0;
        for (int i = 0; i < minLen; i++) {
            sum += arr[i] / minLen;
        }
        dp[0] = sum;
        for (int i = 1; i <= n - minLen; i++) {
            dp[i] = dp[i - 1] + arr[i + minLen - 1] / minLen - arr[i - 1] / minLen;
        }
        double[] sums = Arrays.copyOf(dp, n);

        int[] lens = new int[n];
        Arrays.fill(lens, minLen);
        for (int i = n - minLen - 1; i >= 0; i-- ) {
            double num2 = arr[i] / (lens[i + 1] + 1) + dp[i + 1] * lens[i + 1] / (lens[i + 1] + 1);
            if (dp[i] < num2 || Math.abs(dp[i] - num2) <= 1e-10) {
                dp[i] = num2;
                lens[i] = 1 + lens[i + 1];
            }
        }
        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(dp[i] - max) <= 1e-10) {
                int len = Math.abs(arr[i] - max) <= 1e-10 ? minLen : lens[i + 1];
                list.add(new int[] { i, len });
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        System.out.println(list.get(0)[0] + " " + list.get(0)[1]);
    }
}
