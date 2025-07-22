package huweiA;

import java.util.*;

public class Ode0113 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 6; i <= n; i++) {
            int sum = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    if (j * j == i) {
                        sum += j;
                    }else {
                        sum += j + i / j;
                    }
                    if (sum > i - 1) break;
                }
            }
            if (sum + 1 == i) {
                res.add(i);
                count++;
            }
        }
        sc.close();
        System.out.println(count);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

}
