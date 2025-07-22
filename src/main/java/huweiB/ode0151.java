package huweiB;

import java.util.*;

public class ode0151 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            char[] c = ss[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            res.add(s);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < res.size(); i++) {
            String s = res.get(i);
            if (map.containsKey(s)) {
                map.put(s,map.get(s)+1);
            } else {
                map.put(s,1);
            }
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = map.get(o1);
                int num2 = map.get(o2);
                if (num1 != num2) {
                    return num2 - num1;
                }
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
}
