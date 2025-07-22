package huweiB;

import java.util.*;

public class ode0040 {

    static int[] mins = new int[] {100,1000,10000,100000,1000000,10000000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        if (n < 3 || n > 7 || m < 0) {
            System.out.println(-1);
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, (int)Math.pow(i,n));
        }
        int index = 0, res = 0;
        out : for (int i = mins[n-3]; i < mins[n-2]; i++) {
            int sum = 0, cur = i;
            while (cur > 0) {
                sum += map.get(cur % 10);
                cur /= 10;
                if (sum > i) continue out;
            }
            if (sum == i) {
                res = sum;
                if (index++ == m) {
                    System.out.println(res);
                    return;
                }
            }
        }
        System.out.println(res * m);
        sc.close();
    }
}
