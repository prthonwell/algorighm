package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0068 {
    static HashMap< String, Integer > map = new HashMap<>();
    static {
        map.put( "3", 0);
        map.put( "4", 1);
        map.put( "5", 2);
        map.put( "6", 3);
        map.put( "7", 4);
        map.put( "8", 5);
        map.put( "9", 6);
        map.put( "10", 7);
        map.put( "J", 8);
        map.put( "Q", 9);
        map.put( "K", 10);
        map.put( "A", 11);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] spec = new int[12];
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("2")) continue;
            spec[map.get(s[i])]++;
        }
        int len = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (spec[i] > 0) {
                len++;
            } else {
                if (len >= 5) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = i - len; j <= i - 1; j++) {
                        list.add(j);
                    }
                    res.add(list);
                }
                len = 0;
            }
        }
        if (len >= 5) {
            List<Integer> list = new ArrayList<>();
            for (int j = 12 - len; j <= 11; j++) {
                list.add(j);
            }
            res.add(list);
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if (res.isEmpty()) {
            System.out.println("No");
            return;
        }
        for (List<Integer> list : res) {
            StringJoiner sj = new StringJoiner(" ");
            for (Integer i : list) {
                if (i <= 7) sj.add(i+3 + "");
                else if (i == 8) sj.add("J");
                else if (i == 9) sj.add("Q");
                else if (i == 10) sj.add("K");
                else if (i == 11) sj.add("A");
            }
            System.out.println(sj.toString());
        }
    }
}
