package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            int c = sc.nextInt();
            max = Math.max(max, c);
            pq.offer(c);
        }
        if (n >= m) {
            System.out.println(max);
            return;
        }
        int[] worker = new int[n];
        for (int i = 0; i < n; i++) {
            worker[i] = pq.poll();
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int pass = worker[0];
            time += pass;
            for (int i = 0; i < n - 1; i++) {
                worker[i] = worker[i + 1] - pass;
            }
            worker[n - 1] = pq.poll();
        }
        System.out.println(time + worker[n - 1]);
    }
}
