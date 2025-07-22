package huweiA;

import java.util.*;

public class AIsq {
    static int high = 0;

    static class light {
        int sq;
        int right;
        int left;
        int top;
        int bottom;

        light (int sq, int right, int left, int top, int bottom) {
            this.sq = sq;
            this.right = right;
            this.left = left;
            this.top = top;
            this.bottom = bottom;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<light> pq = new PriorityQueue<>(new Comparator<light>() {
            @Override
            public int compare(light o1, light o2) {
                return o1.top - o2.top;
            }
        });
        while (n-- > 0) {
            int sq = scanner.nextInt();
            int left = scanner.nextInt();
            int top = scanner.nextInt();
            int right = scanner.nextInt();
            int bottom = scanner.nextInt();
            if (high == 0) high = bottom - top;
            pq.add(new light(sq, right, left, top, bottom));
        }
        while (!pq.isEmpty()) {
            light first = pq.poll();
            if (!pq.isEmpty() && pq.peek().top - first.top <= high / 2) {
                List<light> cur = new ArrayList<>();
                cur.add(first);
                while (!pq.isEmpty() && pq.peek().top - first.top <= high / 2) {
                    cur.add(pq.poll());
                }
                cur.sort(Comparator.comparingInt(light -> light.left));
                for (light l : cur) {
                    System.out.print(l.sq + " ");
                }
            } else {
                System.out.print(first.sq + " ");
            }
        }
        scanner.close();
    }
}