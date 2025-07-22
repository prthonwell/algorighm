package huweiA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ode0068 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\(\\d+,\\d+\\)");
        Matcher m = p.matcher(s);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group());
        }
        List<Integer> distance = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        outer: for (String str : list) {
            str = str.substring(1, str.length() - 1);
            String[] posStr = str.split(",");
            if (posStr.length != 2) {
                continue outer;
            }
            int[] pos = new int[2];
            for (int i = 0; i < 2; i++) {
                char first = posStr[i].charAt(0);
                if (first == '0') {
                    continue outer;
                }
                int num;
                try {
                    num = Integer.parseInt(posStr[i]);
                } catch (RuntimeException e) {
                    continue outer;
                }
                if (num >= 1000 || num <= 0) continue outer;
                pos[i] = num;
            }
            int num = pos[0] * pos[0] + pos[1] * pos[1];
            distance.add(num);
            if (!map.containsKey(num)) {
                map.put(num, str);
            }
        }
        if (distance.isEmpty()) {
            System.out.println("(0,0)");
            return;
        }
        distance.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("(" + map.get(distance.get(0)) + ")");
    }
}
