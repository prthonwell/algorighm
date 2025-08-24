package huaweiB;

import java.util.*;

public class ode0148 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            list.add(arr);
        }
        int pre = -1, res = 0;
        for (int[] arr : list) {
            int min = Integer.MAX_VALUE, pos = -1;
            for (int i = 0; i < 3; i++) {
                if (i == pre) continue;
                if (arr[i] <= min) {
                    min = arr[i];
                    pos = i;
                }
            }
            pre = pos;
            res += min;
        }
        System.out.println(res);
    }
}
