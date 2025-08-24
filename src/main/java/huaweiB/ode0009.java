package huaweiB;

import java.util.*;

public class ode0009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextLine();
        }
        Arrays.sort( ss , new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getN(o1) - getN(o2);
            }
        });
        for (String s : ss) {
            System.out.println(s);
        }
        sc.close();
    }

    private static int getN(String o1) {
        int res = 0;
        int index = 0;
        int temp = 0;
        while (index < o1.length()) {
            char c = o1.charAt(index);
            if (c <= '9' && c >= '0') {
                temp = temp * 10 + (c - '0');
            } else if (c == 'G') {
                res += temp * 1024;
                temp = 0;
            } else if (c == 'T') {
                res += temp * 1024 * 1024;
                temp = 0;
            } else if (c == 'M') {
                res += temp;
                temp = 0;
            }
            index++;
        }
        return res;
    }
}
