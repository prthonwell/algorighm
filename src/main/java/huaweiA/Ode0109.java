package huaweiA;

import java.util.*;

public class Ode0109 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String ss1 : ss) {
            list.add(Integer.parseInt(ss1));
        }
        sc.close();
        list.sort( Collections.reverseOrder() );
        int r = list.size() ,l = 0;
        while (l < r) {
            int mid = (l + r)/2;
            if (check(new int[mid], list, 0)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int[] cup, List<Integer> list, int i) {
        if (i == list.size()) {
            return true;
        }
        for (int j = 0; j < cup.length; j++) {
            if (j != 0 && cup[j] == cup[j - 1]) continue;
            if (list.get(i) + cup[j] > 500) continue;
            cup[j] += list.get(i);
            if (check(cup, list, i + 1)) return true;
            cup[j] -= list.get(i);
        }
        return false;
    }
}
