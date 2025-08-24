package huaweiB;

import java.util.*;

public class odb0020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        HashSet< Integer > arrived = new HashSet<>();
        HashMap< Integer ,List<Integer>> map = new HashMap<>();
        for ( int i = 0; i < n; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arrived.add( b );
            map.putIfAbsent( a, new ArrayList<>() );
            map.get( a ).add( b );
        }
        int head = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (!arrived.contains(entry.getKey())) {
                head = entry.getKey();
                break;
            }
        }
        if (head == -1) {
            System.out.println(-1);
            return;
        }
        sc.close();
        arrived.clear();
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> added = new HashSet<>();
        if (!dfs(arrived, head, map, res, added)) {
            System.out.println(-1);
        } else {
            res.sort( Integer::compareTo );
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append( head ).append( ' ' );
            for (Integer i : res) {
                stringBuilder.append( i ).append( ' ' );
            }
            System.out.println( stringBuilder.substring( 0, stringBuilder.length() - 1 ) );
        }
    }

    private static boolean dfs(HashSet<Integer> visited, int cur, HashMap<Integer, List<Integer>> map, List<Integer> res, HashSet<Integer> added) {
        if (visited.contains(cur)) {
            return false;
        }
        visited.add( cur );
        if (!map.containsKey(cur)) {
            if (!added.contains( cur )) {
                added.add( cur );
                res.add(cur);
            }
        }else {
            for (Integer i : map.get(cur)) {
                if (!dfs(visited, i, map, res, added)) return false;
            }
        }
        visited.remove( cur );
        return true;
    }
}
