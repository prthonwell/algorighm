package huaweiA;

import java.util.*;

public class Ode0128 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        sc.close();
        HashSet<String> res = new HashSet<>();
        out: for (String s : arr) {
            s = s.toUpperCase();
            char start = s.charAt(0);
            if (!(start == 'V' || start == 'R' || start == 'C' || start == 'B')) {
                continue;
            }
            HashMap<Character,String> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'V' || c == 'R' || c == 'C' || c == 'B') {
                    StringBuilder sb = new StringBuilder();
                    i++;
                    while (i < s.length()) {
                        char cur = s.charAt(i++);
                        if (cur >= '0' && cur <= '9') {
                            sb.append(cur);
                        } else if (cur == ' '){

                        } else {
                            break;
                        }
                    }
                    if (map.containsKey(c) || sb.length() > 3 || sb.isEmpty()) {
                        continue out;
                    }
                    while (sb.length() < 3) {
                        sb.insert(0, '0');
                    }
                    map.put(c, sb.toString());
                    if (i == s.length()) {
                        break;
                    }
                    i-=2;
                } else {
                    continue out;
                }
            }
            if (!map.containsKey('V') || !map.containsKey('R') || !map.containsKey('C')) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('V');
            sb.append(map.get('V'));
            sb.append('R');
            sb.append(map.get('R'));
            sb.append('C');
            sb.append(map.get('C'));
            if (map.containsKey('B')) {
                sb.append('B');
                sb.append(map.get('B'));
            }
            res.add(sb.toString());
        }
        if (res.isEmpty()) {
            System.out.println("-1");
        }else {
            res.stream().sorted().forEach(System.out::println);
        }

    }

}