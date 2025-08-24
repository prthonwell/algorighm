package huaweiA;

import java.util.*;

public class Ode0067 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cost = sc.nextLine();
        String price = sc.nextLine();
        int money = sc.nextInt();
        sc.close();
        String[] cs = cost.split(",");
        String[] ps = price.split(",");
        int m = cs.length;
        int[][] costs = new int [m][2];
        for (int i = 0; i < m; i++) {
            costs[i][0] = Integer.parseInt(cs[i]);
            costs[i][1] = Integer.parseInt(ps[i]) - costs[i][0];
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] product : costs) {
            if (product[0] > money) {
                break;
            } else {
                money = Math.max(product[1] + money, money);
            }
        }
        System.out.println(money);
    }
}
