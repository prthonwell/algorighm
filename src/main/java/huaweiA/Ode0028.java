package huaweiA;

import java.util.*;

public class Ode0028 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] ss = s.split(" ");
        int n = ss.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(ss[i]);
        }
        HashMap<Long, Integer> res = new HashMap<>();
        for (int i = 2; i < n; i++) {
            long num = arr[i];
            long newNum = 0, times = 4, m = 1 << 24;
            while (times-- > 0) {
                newNum += num / m;
                num = num % m;
                m >>= 8;
            }
            long index = newNum % arr[1];
            if (index < arr[0]) {
                if (res.containsKey(index)) {
                    res.put(index, res.get(index) + 1);
                } else {
                    res.put(index, 1);
                }
            }
        }
        int Max = 0;
        for (Map.Entry<Long, Integer> entry : res.entrySet()) {
            if (entry.getValue() > Max) {
                Max = entry.getValue();
            }
        }
        System.out.println(Max);

    }
}