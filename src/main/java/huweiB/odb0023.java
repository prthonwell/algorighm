package huweiB;

import java.util.*;

public class odb0023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(",");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (index < M && index < n) {
            pq.add(a[index]);
            index++;
        }
        if (M >= n) {
            System.out.println(pq.poll());
            return;
        }
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        res.add(pq.peek());
        while (index < n) {
            int out = a[index - M];
            map.put(out, map.getOrDefault(out, 0) + 1);
            pq.add(a[index]);
            int cur = pq.peek();
            while (map.containsKey(cur)) {
                if (map.get(cur) == 1) {
                    map.remove(cur);
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
                pq.poll();
                cur = pq.peek();
            }
            res.add(cur);
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : res) {
            sb.append(i).append(",");
        }
        sc.close();
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
