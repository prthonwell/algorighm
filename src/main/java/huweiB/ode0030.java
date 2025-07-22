package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class ode0030 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int k = n / m + (n % m == 0 ? 0 : 1);
        int[][] arr = new int[m][k];
        int t = 0, b = m - 1, l = 0, r = k - 1;
        int index = 1;
        out : while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                arr[t][i] = index++;
                if (index > n) break out;
            }
            for (int i = t + 1; i <= b; i++) {
                arr[i][r] = index++;
                if (index > n) break out;
            }
            for (int i = r - 1; i >= l; i--) {
                arr[b][i] = index++;
                if (index > n) break out;
            }
            for (int i = b - 1; i >= t + 1; i--) {
                arr[i][l] = index++;
                if (index > n) break out;
            }
            l++;
            r--;
            t++;
            b--;
        }
        for (int[] arr1 : arr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != 0) sb.append(arr1[i]).append(" ");
                else sb.append("*").append(" ");
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
