package huaweiB;

import java.util.*;

public class ode0025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            sum += arr[i];
        }
        int k = Math.abs(128 * n - sum);
        int l = -k, r = k;
        while (l < r) { // 一定得到满足要求的第一个数
            int m = (l + r) / 2;
            if (check(arr, m, n)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int dif1 = 0;
        int dif2 = 0;
        int dif3 = 0;
        for (int i = 0; i < n; i++) {
            dif1 += Math.min(255, (Math.max(arr[i] + l, 0)));
            dif2 += Math.min(255, (Math.max(arr[i] + l - 1, 0)));
            dif3 += Math.min(255, (Math.max(arr[i] + l + 1, 0)));
        }
        dif1 = Math.abs(dif1 - 128 * n);
        dif2 = Math.abs(dif2 - 128 * n);
        dif3 = Math.abs(dif3 - 128 * n);
        if (dif1 >= dif2 && dif3 >= dif2) {
            System.out.println(l - 1);
        } else if (dif3 >= dif1 && dif2 >= dif1) {
            System.out.println(l);
        } else if (dif2 >= dif3 && dif1 >= dif3) {
            System.out.println(l + 1);
        }
    }

    private static boolean check(int[] arr, int m, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(255, (Math.max(arr[i] + m, 0)));
        }
        return sum >= n * 128;
    }
}
