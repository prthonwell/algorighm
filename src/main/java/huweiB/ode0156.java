package huweiB;

import java.util.*;

public class ode0156 {
    static HashSet<Character> yuan = new HashSet<>();
    static {
        yuan.add( 'a');
        yuan.add( 'e');
        yuan.add( 'i');
        yuan.add( 'o');
        yuan.add( 'u');
        yuan.add( 'A');
        yuan.add( 'E');
        yuan.add( 'I');
        yuan.add( 'O');
        yuan.add( 'U');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();
        int m = s.length();
        int[] sums = new int[m];
        List<Integer> pos = new ArrayList<>();
        if (yuan.contains(s.charAt(0))) {
            sums[0]++;
            pos.add(0);
        }
        for (int i = 1; i < m; i++) {
            char c = s.charAt(i);
            if (yuan.contains(c)) {
                sums[i] = sums[i - 1] + 1;
                pos.add(i);
            } else {
                sums[i] = sums[i - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < pos.size(); i++) {
            for (int j = i + 1; j < pos.size(); j++) {
                int start = pos.get(i);
                int end = pos.get(j);
                int len = end - start + 1;
                int fro = len - (sums[end] - (start == 0 ? 0 : sums[start - 1])) ;
                if (fro == n && len > max) {
                    max = len;
                } else if (fro > n) {
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
