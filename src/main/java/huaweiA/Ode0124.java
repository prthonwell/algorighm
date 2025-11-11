package huaweiA;
import java.util.*;

public class Ode0124 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] cur = new int[2];
            int ID = sc.nextInt();
            cur[0] = sc.nextInt(); //
            cur[1] = sc.nextInt();
            int accept = sc.nextInt();
            if (accept != 0) {
                continue;
            }
            if (map.containsKey(ID) && cur[1] < 100) {
                int[] prev = map.get(ID);
                prev[0] += cur[0];
            } else {
                map.put(ID, cur);
            }
        }
        PriorityQueue<Map.Entry<Integer, int[]>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Integer, int[]> entry = pq.poll();
            int ID = entry.getKey();
            int[] cur = entry.getValue();
            if (cur[1] < 100 && cur[0] >= 100) {
                cur[1] = cur[1] * 9 / 10 + (cur[1] * 9 % 10 > 0 ? 1 : 0);
            }
            System.out.println(ID + " " + cur[0] + " " + cur[1]);
        }

    }
}
