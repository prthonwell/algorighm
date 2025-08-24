package huaweiA;

import java.util.*;

public class Ode0102 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] machines = new int[m][2];
            for (int j = 0; j < m; j++) {
                machines[j][0] = sc.nextInt();
                machines[j][1] = sc.nextInt();
            }
            Arrays.sort(machines, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            int start = 0, end = 0;
            for (int[] machine : machines) {
                start += machine[0];
                end = Math.max(start + machine[1], end);
            }
            res[i] = end;
        }
        for (int i : res) {
            System.out.println(i);
        }
    }
}
