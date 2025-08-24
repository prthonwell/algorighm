package huaweiA;

import java.util.*;

public class Ode0086 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] ss = s.split(",");
        Queue<Integer> Pos = new LinkedList<>();
        for (String ss1 : ss) {
            Pos.offer(Integer.parseInt(ss1));
        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            ss = line.split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }
        HashSet<Integer> set = new HashSet<>(Pos);
        int res = 0;
        while (!Pos.isEmpty()) {
            int cur = Pos.poll();
            for (int i = 0; i < n; i++) {
                if (matrix[cur][i] == 1 && !set.contains(i)) {
                    res++;
                    set.add(i);
                    Pos.offer(i);
                }
            }
        }
        sc.close();
        System.out.println(res);
    }
}
