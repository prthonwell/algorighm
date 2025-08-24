package huaweiA;

import java.util.*;

public class Ode0056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = ss.length;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(ss[i]);
        }
        sc.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            i++;
            res += i * (((count - 1) / i) + 1);
        }
        System.out.println(res);
    }
}
