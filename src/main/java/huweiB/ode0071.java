package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0071 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] offset = new int[m];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == m) continue;
            offset[a] = b;
        }
        long high = 0, sum = 0;
        for (int i = 0; i < m; i++) {
            high += offset[i];
            sum += Math.abs(high);
        }
        System.out.println(sum);
    }
}
