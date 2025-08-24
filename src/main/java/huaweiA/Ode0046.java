package huaweiA;

import java.util.*;

public class Ode0046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] ss = s.split(",");
        int n = ss.length;
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>(); // 记录个数
        List<Integer> list = new ArrayList<>(); // 记录顺序
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ss[i]);
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                list.add(arr[i]);
            }
        }
        List<int[]> res = new ArrayList<>(); // 记录保持顺序的个数
        for (int i : list) {
            res.add(new int[]{i, map.get(i)});
        }
        res.sort((a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();
        for (int[] a : res) {
            sb.append(a[0]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
