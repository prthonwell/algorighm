package huweiA;

import java.util.*;

public class Ode0101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int m = sc.nextInt();
        sc.close();
        if (n < m) {
            System.out.println(0);
            return;
        }
        int index = 0, sum = 0, max = Integer.MIN_VALUE;
        while (index < m) {
            sum += list.get(index);
            index++;
        }
        max = sum;
        while (index < n) {
            sum += list.get(index);
            sum -= list.get(index - m);
            max = Math.max(max, sum);
            index++;
        }
        System.out.println(max);
    }
}
