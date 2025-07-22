package huweiB;

import java.util.*;

public class ode0010  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextLine();
            if (i == start) continue;
            char s = ss[i].charAt(0);
            map.putIfAbsent(s, new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return ss[o1].length() != ss[o2].length() ?
                            ss[o2].length() - ss[o1].length() :
                            ss[o1].compareTo(ss[o2]);
                }
            }));
            map.get(s).add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ss[start]);
        char end = ss[start].charAt(ss[start].length() - 1);
        while (map.containsKey(end)) {
            PriorityQueue<Integer> pq = map.get(end);
            String cur = ss[pq.poll()];
            if (pq.isEmpty()) {
                map.remove(end);
            }
            sb.append(cur);
            end = cur.charAt(cur.length() - 1);
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
