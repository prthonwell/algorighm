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
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'V' || c == 'R' || c == 'C' || c == 'B') {
                    StringBuilder sb = new StringBuilder();
                    while (i < s.length()) {
                        char cur = s.charAt(i++);
                        if (cur >= '0' && cur <= '9') {
                            sb.append(cur);
                        } else if (cur == ' '){

                        } else {
                            break;
                        }
                    }
                    i--;
                    int num = Integer.parseInt(sb.toString());
                    if (map.containsKey(c)) {
                        continue out;
                    }
                    map.put(c, num);
                } else {
                    continue out;
                }
            }
            if (map.size() < 3 || map.size() > 4) {
                continue;
            }
            StringBuilder sb = new StringBuilder();

        }
    }

}