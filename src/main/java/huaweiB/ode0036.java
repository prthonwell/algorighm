package huaweiB;

import java.util.*;

public class ode0036 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(0, 0, 0, a, sum, res);
        System.out.println(res[0]);
        sc.close();
    }

    private static void dfs(int index, int count, int path, int[] a, int sum, int[] res) {
        if (count == 5) {
            res[0] = Math.min(res[0], Math.abs((sum - path) - path));
            return;
        } else if (10 - index == 5 - count) {
            for (int i = index; i < 10; i++) {
                path += a[i];
            }
            res[0] = Math.min(res[0], Math.abs((sum - path) - path));
            return;
        }
        for (int i = index; i < 6 + count; i++) {
            dfs(i + 1, count + 1, path + a[i], a, sum, res );
        }
    }
}
