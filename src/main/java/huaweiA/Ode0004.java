package huaweiA;

import java.util.*;
import java.util.stream.Collectors;

public class Ode0004 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int index = 1;
        List<String> result = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            String s = sc.next();
            if (s.equals("IN")) {
                int printer = sc.nextInt();
                int priority = sc.nextInt();
                ArrayList<int[]> q = map.computeIfAbsent(printer, k -> new ArrayList<>());
                q.add(new int[] { priority, index });
                index++;
            } else {
                int printer = sc.nextInt();
                ArrayList<int[]> q = map.get(printer);
                if (q == null || q.isEmpty()) {
                    result.add("NULL");
                } else {
                    q = q.stream().sorted(new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return o2[0] - o1[0];
                        }
                    }).collect(Collectors.toCollection(ArrayList::new));
                    result.add(String.valueOf(q.get(0)[1]));
                    q.remove(0);
                    map.put(printer, q);
                }
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}