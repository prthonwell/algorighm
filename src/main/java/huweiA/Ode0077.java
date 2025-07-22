package huweiA;

import java.util.*;

public class Ode0077 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        sc.close();
        s = s.substring(1, s.length() - 1);
        String[] ss = s.split(",");
        int n = ss.length;
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(ss[i].trim());
        }
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, 0, prices, money);
        if (res.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println("[" + String.join(", ", res) + "]");
        }
    }

    private static void dfs(List<String> res, List<Integer> path, int i, int[] prices, int money) {
        if (money == 0) {
            String[] cur = path.stream().map(String::valueOf).toArray(String[]::new);
            res.add("[" + String.join(", ", cur) + "]");
            return;
        }
        for (int j = i; j < prices.length; j++) {
            if (money < prices[j]) continue;
            path.add(prices[j]);
            dfs(res, path, j, prices, money - prices[j]);
            path.remove(path.size() - 1);
        }
    }
}
