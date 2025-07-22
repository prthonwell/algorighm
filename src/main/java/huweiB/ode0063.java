package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0063 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length, max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            max = Math.max(max, arr[i]);
        }
        int time = sc.nextInt();
        if (n > time) {
            System.out.println(0);
            return;
        } else if (n == time) {
            System.out.println(max);
            return;
        }
        int l = 0, r = max;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(arr, m, time)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        sc.close();

        System.out.println(l);
    }

    private static boolean check(int[] arr, int m, int time) {
        for (int i = 0; i < arr.length; i++) {
            int cost = arr[i] / m + (arr[i] % m == 0 ? 0 : 1);
            time -= cost;
            if (time <= 0) {
                return false;
            }
        }
        return true;
    }
}
