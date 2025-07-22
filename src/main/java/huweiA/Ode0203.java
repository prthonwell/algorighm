package huweiA;

import java.util.*;

public class Ode0203 {
    public static void main( String[] args ) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        Scanner sc = new Scanner( System.in );
        int N = sc.nextInt();
        while ( N-- > 0 ) {
            String s = sc.next();
            if (s.equals("a")) {
                int sq = sc.nextInt();
                int priority = sc.nextInt();
                if (map.containsKey(priority)) {
                    map.get(priority).offer(sq);
                } else {
                    map.put( priority, new LinkedList<>() );
                    map.get(priority).add( sq );
                }
            } else {
                if (map.isEmpty()) {
                    System.out.println(" ");
                    continue;
                }
                Map.Entry<Integer, Queue<Integer>> entry = map.firstEntry();
                Queue<Integer> cur = entry.getValue();
                System.out.println(cur.poll());
                if (cur.isEmpty()) map.remove(entry.getKey());
            }
        }
    }
}