package huaweiB;

import java.util.*;

public class ode0089 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        out: while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) break;
            List<Integer> list = Arrays
                    .stream(s.split(" "))
                    .map(Integer::parseInt)
                    .toList();
            List<Integer> pokes = new ArrayList<>(Arrays
                    .stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toList());
            int[] sums = new int[pokes.size()];
            for (int i = 0; i < pokes.size(); i++) {
                if (i == 0) sums[i] = pokes.get(i);
                else sums[i] = sums[i - 1] + pokes.get(i);
                if (sums[i] % list.get(1) == 0) {
                    res.add(1);
                    continue out;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < pokes.size(); i++) {
                sums[i] = sums[i] % list.get(1);
                if (set.contains(sums[i])) {
                    res.add(1);
                    continue out;
                } else set.add(sums[i]);
            }
            res.add(0);
        }
        for (Integer integer : res) {
            System.out.println(integer);
        }
        sc.close();
    }
}
