package huaweiB;

import java.util.*;

public class ode0017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                a[i] = Integer.parseInt(ss[i]);
            } catch (NumberFormatException e) {
                System.out.println("[ ]");
                return;
            }
        }
        if (n == 1 || n == 2) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] != a[i + 1] && (a[i] > a[i + 1] ^ i % 2 == 0)) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int arr : a) {
            sb.append(arr).append(" ");
        }
        System.out.println(sb);
    }

}
