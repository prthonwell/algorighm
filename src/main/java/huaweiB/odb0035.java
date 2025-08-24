package huaweiB;

import java.util.*;

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
        HashMap<String, Integer> map = new HashMap<>();
        int profit = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            String[] ss = line.split(" ");
            if (set.contains(ss[1])) continue;
            String[] time = ss[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]) + hour * 60;
            if (ss[2].equals("enter")) {
                map.putIfAbsent(ss[1], min);
            } else {
                int dis = min - map.get(ss[1]);
                profit += dis > 30 ? (dis - 1) / 30 + 1 : 0;
                map.remove(ss[1]);
            }
        }
        sc.close();
        System.out.println(profit);
    }
}
