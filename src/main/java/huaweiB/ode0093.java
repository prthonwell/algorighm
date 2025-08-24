package huaweiB;

import java.util.*;

public class ode0093 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] matrix = new int[n][m];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                max = Math.max(max, matrix[i][j]);
                min = Math.min(min, matrix[i][j]);
            }
        }
        sc.close();
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (check(mid, matrix, k)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    private static boolean check(int mid, int[][] matrix, int k) {
        // 判断如果以mid作为第K大的值，是否能找出右k - 1个小于等于它的数
        int[] match = new int[matrix[0].length];
        Arrays.fill(match, -1);
        int num = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (dfs(match, i, matrix, new boolean[matrix[0].length], mid)) num++;
            if (num > matrix.length - k) return true;
        }
        return false;
    }

    private static boolean dfs(int[] match, int i, int[][] matrix, boolean[] visited, int mid) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (!visited[j] && matrix[i][j] <= mid) {
                visited[j] = true;
                if (match[j] == -1 || dfs(match, match[j], matrix, visited, mid)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
