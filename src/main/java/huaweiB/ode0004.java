package huaweiB;

import java.util.*;

public class ode0004 {
    static class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(  int n ) {
            parent = new int[ n ];
            for ( int i = 0; i < n; i++ ) parent[i] = i;
            rank = new int[ n ];
        }
        void union(  int p,  int q ) {
            int rootP = find(p);
            int rootQ = find(q);
            if ( rootP == rootQ ) {
                return;
            } else {
                if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else {
                    if (rootP > rootQ) {
                        parent[rootP] = rootQ;
                        rank[rootQ]++;
                    } else {
                        parent[rootQ] = rootP;
                        rank[rootP]++;
                    }
                }
            }
        }

        int find( int p ) {
            while ( p != parent[ p ] ) {
                p = parent[ p ];
            }
            return p;
        }

        boolean connected( int p, int q ) {
            return find(p) == find(q);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        if (n < 1 || n >= 100000 || m < 1 || m >= 100000) {
            System.out.println("Null");
            return;
        }
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int c = sc.nextInt();
            if (a < 1 || a > n || b < 1 || b > n || (c != 0 && c != 1)) {
                System.out.println("da pian zi");
                continue;
            }
            if (c == 0) {
                uf.union(a, b);
            } else {
                if (uf.connected(a, b)) System.out.println("we are a team");
                else System.out.println("we are not a team");
            }
        }
        sc.close();
    }
}
