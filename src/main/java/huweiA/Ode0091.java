package huweiA;

import java.util.*;

public class Ode0091 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        sc.close();
        if (days < arr.length) {
            System.out.println(-1);
            return;
        }
        int min = (int)sum / days;
        while (min < max) {
            int mid = min + ( max - min ) / 2;
            if (check(mid, days, arr)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean check(int mid, int days, int[] arr) {
        int cost = 0;
        for (int j : arr) {
            cost += j / mid + (j % mid == 0 ? 0 : 1);
            if (cost > days) return false;
        }
        return true;
    }
}
