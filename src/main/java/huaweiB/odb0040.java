package huaweiB;

import java.util.*;

public class odb0040 {
    static class IPRange {
        long start;
        long end;
        String city;
        IPRange(long start, long end, String city) {
            this.start = start;
            this.end = end;
            this.city = city;
        }
    }
    static long parseIP(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res << 8) | Integer.parseInt(parts[i]);
        }
        return res;
    }
    // City1=1.1.1.1,1.1.1.2;City1=1.1.1.11,1.1.1.16;City2=3.3.3.3,4.4.4.4;City3=2.2.2.2,6.6.6.6
    //1.1.1.15,3.3.3.5,2.2.2.3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cities = sc.nextLine().split(";");
        List<IPRange> ranges = new ArrayList<>();
        for (String c : cities) {
            String[] ss = c.split("=");
            String city = ss[0];
            String[] sss = ss[1].split(",");
            long start = parseIP(sss[0]);
            long end = parseIP(sss[1]);
            ranges.add(new IPRange(start, end, city));
        }
        ranges.sort( (ip1, ip2) -> Long.compare(ip1.start, ip2.start) );

        String[] IPs = sc.nextLine().split(",");
        int m = IPs.length;
        long[] searchLongs = new long[m];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            String[] ss = IPs[i].split("\\.");
            for (int j = 0; j < 4; j++) {
                cur = cur << 8 | Integer.parseInt(ss[j]);
            }
            searchLongs[i] = cur;
        }
        // 对查询IP按值排序，记录原始索引
        Integer[] qIndex = new Integer[m];
        for (int i = 0; i < m; i++) qIndex[i] = i;
        Arrays.sort(qIndex, Comparator.comparingLong(i -> searchLongs[i]));

        int index = 0;
        String[] res = new String[m];
        PriorityQueue<long[]> cur = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] != o2[0]) return Long.compare( o1[0], o2[0] );
                else return Long.compare( o1[1], o2[1] );
            }
        });
        for (Integer i : qIndex) {
            while (index < ranges.size() && ranges.get(index).start <= searchLongs[i]) {
                IPRange range = ranges.get(index);
                cur.add(new long[] {range.end - range.start + 1, range.end, index});
                index++;
            }
            while (!cur.isEmpty() && cur.peek()[1] < searchLongs[i]) {
                cur.poll();
            }
            if (cur.isEmpty()) res[i] = "";
            else {
                res[i] = ranges.get((int)cur.peek()[2]).city;
            }
        }
        StringJoiner sj = new StringJoiner(",");
        for (String s : res) sj.add(s);
        System.out.println(sj);
        sc.close();
    }
}
