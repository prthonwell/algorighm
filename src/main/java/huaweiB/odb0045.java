package huaweiB;

import java.util.*;

public class odb0045 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            }
            Arrays.sort(arr);
            int[] sq = new int[n];
            for (int j = 0; j < n; j++) {
                sq[j] = arr[j] * arr[j];
            }
            List<int[]> comb = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index1 = j + 1,index2 = index1 + 1;
                while (index1 < n && sq[j] + sq[index1] <= sq[n - 1]) {

                    while (index2 < n && sq[index2] < sq[index1] + sq[j]) {
                        index2++;
                    }
                    if (sq[index2] == sq[index1] + sq[j]) {
                        comb.add(new int[]{arr[j], arr[index1], arr[index2]});
                    }
                    index1++;
                }
            }
            int[] res = new int[1];
            dfs(res, map, comb, 0, 0);
            System.out.println(res[0]);
        }
        sc.close();
    }

    private static void dfs(int[] res, HashMap<Integer, Integer> map, List<int[]> comb, int i, int num) {
        if (i == comb.size()) {
            res[0] = Math.max(res[0], num);
            return;
        }
        int[] cur = comb.get(i);
        boolean av = true;
        for (int j = 0; j < 3; j++) {
            av &= map.get(cur[j]) > 0;
        }
        if (av) {
            for (int j = 0; j < 3; j++) {
                map.put(cur[j], map.get(cur[j]) - 1);
            }
            dfs(res, map, comb, i + 1, num + 1);
            for (int j = 0; j < 3; j++) {
                map.put(cur[j], map.get(cur[j]) + 1);
            }
        }
        dfs(res, map, comb, i + 1, num);
    }
}
