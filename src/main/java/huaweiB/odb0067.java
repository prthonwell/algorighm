package huaweiB;

import java.util.*;

public class odb0067 {

    public static class Record {
        Integer id;
        Integer score;

        Record(Integer id, Integer score) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] line1 = sc.nextLine().split(",");
        String[] line2 = sc.nextLine().split(",");
        HashMap< Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer id = Integer.parseInt(line1[i]);
            Integer score = Integer.valueOf(line2[i]);
            map.putIfAbsent(id, new PriorityQueue<>((a, b) -> a - b));
            PriorityQueue<Integer> Q = map.get(id);
            Q.add(score);
            if (Q.size() > 3) {
                Q.poll();
            }
        }
        List<Record> records = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> Q = entry.getValue();
            if (Q.size() < 3) {
                continue;
            }
            int score1 = Q.poll();
            int score2 = Q.poll();
            int score3 = Q.poll();
            Integer id = entry.getKey();
            records.add(new Record(id, (score1 + score2 + score3)));
        }
        records.sort((a, b) -> {
            if (!Objects.equals(a.score, b.score)) {
                return b.score - a.score;
            }
            return Integer.compare(b.id, a.id);
        });
        StringJoiner sj = new StringJoiner(",");
        for (Record record : records) {
            sj.add(record.id + "");
        }
        System.out.println(sj.toString());
    }
}
