package huaweiB;

import java.util.*;

public class ode062 {

    static class Node {
        int income;
        HashSet<Node> subs;
        Node( int income ) {
            this.income = income;
            subs = new HashSet<Node>();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < n; i++ ) {
            int id = sc.nextInt();
            int priory = sc.nextInt();
            int income = sc.nextInt();
            if (map.containsKey( id )) {
                map.get( id ).income += priory;
            } else {
                Node cur = new Node( income );
                map.put( id, cur );
            }
            if (map.containsKey( priory )) {
                map.get( priory ).subs.add( map.get( id ) );
            } else {
                Node p = new Node( 0 );
                map.put( priory, p );
                p.subs.add( map.get( id ) );
            }
            set.add( id );
        }
        for (Map.Entry<Integer, Node> entry : map.entrySet() ) {
            if (set.contains( entry.getKey() )) continue;
            Node boss = entry.getValue();
            System.out.println(entry.getKey() + " " + dfs(boss));
            break;
        }
        sc.close();
    }

    private static int dfs(Node cur) {
        int res = cur.income;
        for ( Node sub : cur.subs ) {
            res += dfs( sub ) / 100 * 15;
        }
        return res;
    }
}
