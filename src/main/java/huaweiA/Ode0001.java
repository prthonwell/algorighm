package huaweiA;

import java.util.*;

public class Ode0001 {

    static int[][] moves = new int[][] {{1, 0},{-1,0},{0,1},{0,-1}} ;

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next();
            }
        }
        ArrayList<int[]> starts = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (matrix[0][i].equals("O")) {
                starts.add(new int[]{0, i});
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][n - 1].equals("O")) {
                starts.add(new int[]{i, n - 1});
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (matrix[m - 1][i].equals("O")) {
                starts.add(new int[]{m - 1, i});
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            if (matrix[i][0].equals("O")) {
                starts.add(new int[]{i, 0});
            }
        }
        if (starts.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        PriorityQueue<int[]> map = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] start : starts) {
            int[] pos = start.clone();
            boolean[][] visited = new boolean[m][n];
            int num = count(pos, start, visited, matrix);
            if (num == -1) continue;
            int[] res = new int[3];
            res[0] = pos[0];
            res[1] = pos[1];
            res[2] = num;
            map.offer(res);
        }
        if (map.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        int[] pos1 = map.poll();
        if (map.isEmpty()) {
            System.out.println(pos1[0] + " " + pos1[1] + " " + pos1[2]);
            return;
        }
        int[] second = map.poll();
        if (pos1[2] == second[2]) {
            System.out.println(pos1[2]);
        } else {
            System.out.println(pos1[0] + " " + pos1[1] + " " + pos1[2]);
        }
    }

    private static int count(int[] start, int[] pos, boolean[][] visited, String[][] matrix) {
        if (pos[0] < 0 || pos[0] >= matrix.length ||
                pos[1] < 0 || pos[1] >= matrix[0].length ||
                visited[pos[0]][pos[1]] || matrix[pos[0]][pos[1]].equals("X")) {
            return 0;
        }
        if ((pos[0] == 0 || pos[0] == matrix.length - 1 ||
                pos[1] == 0 || pos[1] == matrix[0].length - 1) &&
                (pos[0] != start[0] || pos[1] != start[1])) {
            return -1;
        }
        visited[pos[0]][pos[1]] = true;
        int count = 1;
        for (int[] move : moves) {
            int[] temp = pos.clone();
            pos[0] += move[0];
            pos[1] += move[1];
            int num = count(start, pos, visited, matrix);
            if (num == -1) {
                return -1;
            }
            count += num;
            pos = temp;
        }
        return count;
    }
}