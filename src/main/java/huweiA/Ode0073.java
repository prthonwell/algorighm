package huweiA;

import java.util.*;

public class Ode0073 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cake = sc.nextLine();
        String gift = sc.nextLine();
        int money = sc.nextInt();
        String[] cs = cake.split(",");
        String[] gs = gift.split(",");
        int n = cs.length;
        int m = gs.length;
        int[] cakes = new int[n];
        int[] gifts = new int[m];
        for (int i = 0; i < n; i++) {
            cakes[i] = Integer.parseInt(cs[i]);
        }
        for (int i = 0; i < m; i++) {
            gifts[i] = Integer.parseInt(gs[i]);
        }
        Arrays.sort(cakes);
        Arrays.sort(gifts);
        int indexC = 0, indexG = m - 1;
        long res = 0;
        while (indexC < n && cakes[indexC] < money) {
            while (indexG >= 0 && cakes[indexC] + gifts[indexG] > money) {
                indexG--;
            }
            if (indexG < 0) break;
            res += indexG + 1;
            indexC++;
        }
        System.out.println(res);
    }
}
