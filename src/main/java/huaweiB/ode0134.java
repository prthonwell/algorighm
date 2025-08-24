package huaweiB;

import java.util.*;

public class ode0134 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int l = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            l = Math.max(l, a[i]);
            sum += a[i];
        }
        sc.close();
        Arrays.sort( a );
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        for (int i = l; i <= sum; i++) {
            if (sum % i == 0 && check(a, i, new int[sum / i],0)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean check(int[] a, int div, int[] cup, int index) {
        if (index == a.length) {
            return true;
        }
        for (int i = 0; i < cup.length; i++) {
            if (a[index] + cup[i] > div) continue;
            if (i != 0 && cup[i] == cup[i - 1]) continue;
            cup[i] = a[index] + cup[i];
            if (check(a, div, cup, index + 1)) return true;
            cup[i] = cup[i] - a[index];
        }
        return false;
    }
}
