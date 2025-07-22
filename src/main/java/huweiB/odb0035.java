package huweiB;

import java.util.*;
import java.util.regex.Pattern;

public class odb0035 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }
        sc.nextLine();
        HashMap<String, List<int[]>> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] ss = line.split(" ");
            if (set.contains(ss[1])) continue;
            String[] time = ss[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]) + hour * 60;
            if (ss[2].equals("enter")) {
                if (map.containsKey(ss[1])) {
                    map.get(ss[1]).add(new int[]{min, 0});
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{min, 0});
                    map.put(ss[1], list);
                }
            } else {
                List<int[]> list = map.get(ss[1]);
                list.get(list.size() - 1)[1] = min;
            }
        }
        int profit = 0;
        for (Map.Entry<String, List<int[]>> entry : map.entrySet()) {
            for (int[] cur : entry.getValue()) {
                int p = 0;
                if (cur[1] <= 690 || cur[0] > 810) {
                    p = (cur[1] - cur[0]) / 30;
                } else {
                    int l = Math.max(0, 690 - cur[0]);
                    int r = Math.max(0, cur[1] - 810);
                    p = (l + r) / 30;
                }
                p = Math.min(p, 16);
                profit += p;
            }
        }
        sc.close();
        System.out.println(profit);
    }
}
