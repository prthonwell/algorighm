package huaweiB;

import java.util.*;

public class ode0082 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int n = ss.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        int res = -1, sum = sc.nextInt(), cur = 0, curLen = 0, l = 0;
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            curLen++;
            while (cur > sum) {
                cur -= arr[l++];
                curLen--;
            }
            if (cur == sum) {
                res = Math.max(res, curLen);
            }
        }

        System.out.println(res);
        sc.close();
    }
}
