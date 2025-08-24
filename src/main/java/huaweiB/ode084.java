package huaweiB;

import java.util.*;

public class ode084 {

    static int[] res = new int[ 2 ];
    static {
        res[ 0 ] = Integer.MAX_VALUE;
        res[ 1 ] = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        if (sum % 2 != 0) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(a);
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        int half = sum / 2;
        int[] count = new int[2]; // 记录左右个数
        dfs(a, half, new int[2], 0, count);
        if (res[0] != Integer.MAX_VALUE) {
            System.out.println(Math.min(res[0], res[1]));
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

    private static void dfs(int[] a, int half, int[] cups, int index, int[] count) {
        if (index == a.length) {
            if (Math.min(count[1], count[0]) < Math.min(res[1], res[0]) ) {
                res[0] = count[0];
                res[1] = count[1];
            }
            return;
        }
        if (cups[0] + a[index] <= half) {
            cups[0] += a[index];
            count[0]++;
            dfs(a, half, cups, index + 1, count);
            cups[0] -= a[index];
            count[0]--;
        }
        if (cups[0] == 0 && cups[1] == 0) return;
        if (cups[1] + a[index] <= half) {
            cups[1] += a[index];
            count[1]++;
            dfs(a, half, cups, index + 1, count);
            cups[1] -= a[index];
            count[1]--;
        }

    }
}
