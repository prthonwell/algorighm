package huweiB;

import java.util.*;

public class ode0088 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> shows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = a + sc.nextInt() + 15;
            shows.add(new int[] { a, b });
        }
        shows.sort( (a, b) -> a[1] - b[1]);
        int r = shows.get(0)[1], res = 1;
        for (int i = 1; i < n; i++) {
            int start = shows.get(i)[0];
            int end = shows.get(i)[1];
            if (r <= start) {
                r = end;
                res++;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
