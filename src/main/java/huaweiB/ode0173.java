package huaweiB;

import java.util.*;

public class ode0173 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt(), type = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<int[]> products = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            max = Math.max(max, b);
            min = Math.min(min, b);
            products.add(new int[] { a, b, c });
        }
        products.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] used = new boolean[type];
        int MinCost = 0;
        for (int i = 0; i < products.size(); i++) {
            if (used[products.get(i)[0]]) continue;
            MinCost += products.get(i)[2];
            used[products.get(i)[0]] = true;
        }
        boolean All = true;
        for (int i = 0; i < used.length; i++) {
            All &= used[i];
        }
        if (MinCost > money || !All) {
            System.out.println(-1);
            return;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(new boolean[type], products, mid, money)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }

    private static boolean check(boolean[] used, List<int[]> products, int mid, int money) {
        int cost = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i)[1] < mid || used[products.get(i)[0]]) continue;
            cost += products.get(i)[2];
            used[products.get(i)[0]] = true;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) return false;
        }
        return cost < money;
    }
}
