package huaweiB;

import java.util.*;

public class odb0053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        int n = list.size();
        if (n == 1) {
            System.out.println(list.get(0));
            return;
        }
        if (n == 2) {
            System.out.println(Math.max(list.get(0), list.get(1)));
            return;
        }
        int[] NoHead = new int[n - 1];
        int[] NoTail = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            NoTail[i] = list.get(i);
        }
        for (int i = 1; i < n; i++) {
            NoHead[i - 1] = list.get(i);
        }
        int a = (int)Math.max(get(NoTail), get(NoHead));
        System.out.println(a);
        sc.close();
    }

    private static double get(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[n - 1] = arr[n - 1];
        dp[n - 2] = Math.max(arr[n - 1], arr[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], arr[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
