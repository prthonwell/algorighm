package huaweiB;

import java.util.*;

public class odb0002 {

    private static class node {
        int color; // 1 hong 2 hei
        int id;
        boolean CanRed;
        List<node> neighbors;
        node (int id) {
            this.id = id;
            color = 0;
            CanRed = true;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        HashMap< Integer, node > map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put( i, new node( i ) );
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            map.get( x ).neighbors.add( map.get( y ) );
            map.get( y ).neighbors.add( map.get( x ) );
        }
        HashSet< Integer > visited = new HashSet<>();
        int result = 1;
        for (Map.Entry<Integer, node > entry : map.entrySet()) {
            if (!visited.contains( entry.getKey() )) {
                List<node> q = new ArrayList<>();
                HashSet<node> set = new HashSet<>();
                collact(q,set, entry.getValue());
                for (node node : q) {
                    visited.add( node.id );
                }
                int[] res = new int[1];
                dfs( q, res, 0);
                result *= res[0];
            }
        }
        System.out.println(result);
    }

    private static void collact(List<node> q, HashSet<node> set, node value) {
        q.add(value);
        set.add(value);
        for (node n : value.neighbors) {
            if (!set.contains( n )) {
                collact(q, set, n);
            }
        }
    }

    private static void dfs(List<node> q, int[] res, int index) {
        if (index == q.size()) {
            res[0]++;
            return;
        }
        node node = q.get( index );
        node.color = 2;
        dfs(q, res, index + 1);
        if (node.CanRed) {
            node.color = 1;
            List<node> effect = new ArrayList<>();
            for (node n : node.neighbors) {
                if (n.CanRed) {
                    effect.add( n );
                    n.CanRed = false;
                }
            }
            dfs(q, res, index + 1);
            for (node n : effect) {
                n.CanRed = true;
            }
        }
        node.color = 0;
    }
}
