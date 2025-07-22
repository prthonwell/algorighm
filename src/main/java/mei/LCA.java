package mei;

import java.util.Arrays;
import java.util.Scanner;

public class LCA {
    public static void lca() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = scanner.nextInt();
            }
            char[] chats = new char[n];
            for (int i = 0; i < n; i++) {
                chats[i] = scanner.next().charAt(0);
            }
            // 倍增
            int[][] ancestors = new int[n][20];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ancestors[i], -1);
                ancestors[i][0] = parent[i] == 0 ? -1 : parent[i] - 1;
            }
            // 倍增
            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < n; j++) {
                    if (ancestors[j][i - 1] != -1) {
                        ancestors[j][i] = ancestors[ancestors[j][i - 1]][i - 1];
                    }
                }
            }
            for (int i = 0; i < q; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                int XDeep = getDeep(ancestors, x);
                int YDeep = getDeep(ancestors, y);
                if (XDeep > YDeep) {
                    int temp = x;
                    x = y;
                    y = temp;
                    int tempDeep = XDeep;
                    XDeep = YDeep;
                    YDeep = tempDeep;
                }
                for (int j = 19; j >= 0; j--) {
                    if (YDeep - (1 << j) >= XDeep) {
                        y = ancestors[y][j];
                        YDeep -= (1 << j);
                    }
                }
                if (x == y) System.out.println(chats[x]);
                for (int j = 19; j >= 0; j--) {
                    if (ancestors[x][j] != -1 && ancestors[x][j] != ancestors[y][j]) {
                        x = ancestors[x][j];
                        y = ancestors[y][j];
                    }
                }
                System.out.println(chats[ancestors[x][0]]);
            }
        }
    }
    public static int getDeep(int[][] ancestors, int x) {
        int deep = 0;
        while (x != -1) {
            deep++;
            x = ancestors[x][0];
        }
        return deep;
    }

    public static void main(String[] args) {
        lca();
    }
}
