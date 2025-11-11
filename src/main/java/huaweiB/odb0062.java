package huaweiB;

import java.util.*;

public class odb0062 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int available = 0, mainPoint = 0;
        boolean[] visited = new boolean[n];
        while (available < n) {
            mainPoint++;
            int start = 0;
            while (start < n && visited[start]) {
                start++;
            }
            visited[start] = true;
            available++;
            Queue<Integer> poses = new LinkedList<>();
            poses.add(start);
            while (!poses.isEmpty()) {
                int cur = poses.poll();
                for (int i = 0; i < n; i++) {
                    if (matrix[cur][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        poses.add(i);
                        available++;
                    }
                }
            }
        }
        System.out.println(mainPoint);
    }

}
