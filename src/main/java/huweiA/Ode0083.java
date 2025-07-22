package huweiA;

import java.util.*;

public class Ode0083 {

    static class combine {
        int sum;
        int nextIndex;
        combine(int sum, int nextIndex) {
            this.sum = sum;
            this.nextIndex = nextIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        PriorityQueue<combine> pq = new PriorityQueue<>((a, b) -> a.sum + arr[a.nextIndex] - b.sum - arr[b.nextIndex]);
        combine c = new combine(0, 0);
        for (int i = 0; i < k; i++) {
            System.out.println(c.sum + arr[c.nextIndex]);
            if (c.nextIndex < n - 1) {
                pq.offer(new combine(c.sum + arr[c.nextIndex], c.nextIndex + 1));
                c.nextIndex++;
                pq.offer(c);
            }
            c = pq.poll();
        }
    }
}
