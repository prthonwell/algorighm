package huaweiA;

import java.util.*;

public class Ode0081 {
    static HashSet<Character> yuan = new HashSet<>();
    static {
        yuan.add('a');
        yuan.add('e');
        yuan.add('i');
        yuan.add('o');
        yuan.add('u');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int res = 0;
        for (String str : ss) {
            int n = str.length();
            if (n < 4) continue;
            boolean reverse = false;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) > 'z' || str.charAt(i) < 'a') {
                    reverse = true;
                    break;
                }
            }
            if (reverse) {
                StringBuilder sb = new StringBuilder(str);
                str = sb.reverse().toString();
            }
            List<Integer> startPos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == 'e') {
                    startPos.add(i);
                }
            }
            int cur = 0;
            int[] dp = new int[n]; // 1表示元，2表示r，3表示非r辅, 4表示其他
            for (Integer i : startPos) {
                if (i + 3 >= n) continue;
                for (int j = i + 1; j < i + 4; j++) {
                    if (dp[j] == 0) {
                        if (yuan.contains(str.charAt(j))) {
                            dp[j] = 1;
                        } else if (str.charAt(j) == 'r') {
                            dp[j] = 2;
                        } else if (str.charAt(j) <= 'z' && str.charAt(j) >= 'a') {
                            dp[j] = 3;
                        } else {
                            dp[j] = 4;
                        }
                    }
                }
                if (dp[i + 1] == 3 && dp[i+2] == 1 && (dp[i+3] == 2 || dp[i+3] == 3)) {
                    cur++;
                }
            }
            res += cur;
        }
        System.out.println(res);
    }
}
