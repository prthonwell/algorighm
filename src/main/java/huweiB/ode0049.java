package huweiB;

import java.util.*;

public class ode0049 {

    static int[][] offset = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                count.put(matrix[i][j],count.getOrDefault(matrix[i][j],0) + 1);
                if (count.get(matrix[i][j]) == 2) {
                    set.add(matrix[i][j]);
                }
            }
        }
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!set.contains(matrix[i][j])) {
                    dist[i][j] = -1;
                } else {
                    List<int[]> start = new ArrayList<>();
                    start.add(new int[]{i,j});
                    int level = 0;
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    boolean found = false;
                    while (!found) {
                        level++;
                        int len = start.size();
                        out : while (len-- > 0) {
                            int[] arr = start.remove(0);
                            for (int l = 0; l < 4; l++) {
                                int a = arr[0] + offset[l][0];
                                int b = arr[1] + offset[l][1];
                                if (a < 0 || b < 0 || a >= n || b >= m
                                        || visited[a][b]) continue;
                                visited[a][b] = true;
                                if (matrix[a][b] == matrix[i][j]) {
                                    found = true;
                                    break out;
                                }
                                start.add(new int[]{a,b});
                            }
                        }
                    }
                    dist[i][j] = level;
                }
            }
        }
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < n; i++) {
            StringJoiner sj1 = new StringJoiner(", ");
            for (int j = 0; j < m; j++) {
                sj1.add(dist[i][j] + "");
            }
            sj.add("[" + sj1.toString() + "]");
        }
        System.out.println("[" + sj.toString() + "]");
    }
}
