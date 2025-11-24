package huaweiB;

import java.util.*;

public class odb0069 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] processes = new int[n][3];
        for (int i = 0; i < n; i++) {
            processes[i][0] = sc.nextInt();
            processes[i][1] = sc.nextInt();
            processes[i][2] = sc.nextInt();
        }
        int cur = 0, res = 0;
        PriorityQueue<int[]> starts = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        starts.addAll(Arrays.asList(processes));

        while (!starts.isEmpty()) {
            if (!ends.isEmpty() && ends.peek()[1] <= starts.peek()[0]) {
                int[] end = ends.poll();
                cur -= end[2];
            } else {
                int[] start = starts.poll();
                cur += start[2];
                ends.add(start);
                res = Math.max(res, cur);
            }
        }
        System.out.println(res);
    }
}
