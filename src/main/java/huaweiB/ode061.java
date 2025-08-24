package huaweiB;

import java.util.*;

public class ode061 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), total = sc.nextInt(), risk = sc.nextInt();
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }
        int[] risks = new int[n];
        for (int i = 0; i < n; i++) {
            risks[i] = sc.nextInt();
        }
        int[] mount = new int[n];
        for (int i = 0; i < n; i++) {
            mount[i] = sc.nextInt();
        }
        int[] res = new int[5]; // (产品号， 购买量) * 2，总收益
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (risks[i] + risks[j] > risk) continue;
                int[] Best = getBest(i,j,profits,mount,total);
                if (Best[4] > res[4]) {
                    res = Best;
                }
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            if (i != res[0] && i != res[2]) {
                sj.add(0 + "");
            } else if (i == res[0]) {
                sj.add(res[1] + "");
            } else {
                sj.add(res[3] + "");
            }
        }
        System.out.println(sj.toString());
        sc.close();
    }

    private static int[] getBest(int i, int j, int[] profits, int[] mount, int total) {
        int[] Best = new int[5];
        Best[0] = i;
        Best[2] = j;
        if (profits[i] > profits[j]) {
            Best[1] = Math.min(total, mount[i]);
            Best[3] = Math.min(mount[j], Math.max(0, total - mount[i]));
            Best[4] += Best[1] * profits[i] + Best[3] * profits[j];
        } else {
            Best[3] = Math.min(total, mount[j]);
            Best[1] = Math.min(mount[i], Math.max(0, total - mount[j]));
            Best[4] += Best[1] * profits[i] + Best[3] * profits[j];
        }
        return Best;
    }


}
