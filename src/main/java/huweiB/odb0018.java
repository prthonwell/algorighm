package huweiB;

import java.util.*;

public class odb0018 {
    static long ans = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        // 市民数量
        int n = Integer.parseInt(ss[0]);
        // 店铺数量
        int m = Integer.parseInt(ss[1]);

        // shop_costs是一个字典，key为店铺id，value为该店铺名下的市民
        HashMap<Integer, List<Integer>> shop_costs = new HashMap<>();

        // 获取n行输入
        for (int i = 0; i < n; i++) {
            ss = sc.nextLine().split(",");
            // 店铺id, 改选自己店铺的花费
            int shop = Integer.parseInt(ss[0]);
            int cost = Integer.parseInt(ss[1]);

            // shop_costs是一个字典，key为店铺id，value为该店铺名下的市民
            shop_costs.putIfAbsent(shop, new ArrayList<>());
            shop_costs.get(shop).add(cost);
        }

        // 我们店铺选票数的左右边界
        int l = 1, r = 0;
        for (List<Integer> list : shop_costs.values()) {
            list.sort(Integer::compareTo);
            r = Math.max(r, list.size());
        }
        r++;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, shop_costs) < check(mid + 1, shop_costs)) r = mid;
            else l = mid + 1;
        }

        sc.close();
        System.out.println(ans);
    }

    private static long check(int mid, HashMap<Integer, List<Integer>> shopCosts) {
        int my_support = 0; // 我的票数
        long my_cost = 0; // 我的开销 也就是答案


        List<Integer> rest = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : shopCosts.entrySet()) {
            if (entry.getKey() == 1) {
                my_support += entry.getValue().size();
                continue;
            }
            // 每个店铺超出的部分必须买掉
            List<Integer> list = entry.getValue();
            int i = 0, k = list.size();
            while (k >= mid) {
                int cost = list.get(i);
                my_cost += cost;
                my_support++;
                i++;
                k--;
            }
            // 剩下未超出的部分用于一会儿补足
            while (i < list.size()) {
                rest.add(list.get(i));
                i++;
            }
        }
        // 如果达不到mid，从小的开始买
        if (my_support < mid) {
            rest.sort(Integer::compareTo);
            while (my_support < mid) {
                my_cost += rest.remove(0);
                my_support++;
            }
        }
        ans = Math.min(ans, my_cost);
        return my_cost;
    }
}
