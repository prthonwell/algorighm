package huaweiA;

import java.util.*;

public class Ode0110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = sc.nextLine();
        sc.close();
        char[] ss = s.toCharArray();
        char[] strs = str.toCharArray();
        int n = ss.length;
        int m = strs.length;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                if (ss[i] == strs[0]) {
                    System.out.println(i);
                    return;
                }
            }
        }
        int[] nexts = buildKmp(strs);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ss[i] == strs[index]) {
                index++;
                if (index == m) {
                    System.out.println(i - m + 2);
                    return;
                }
            } else {
                if (nexts[index] != -1) {
                    index = nexts[index];
                    i--;
                } else {
                    index = 0;
                }
            }
        }
        System.out.println("No");
    }

    private static int[] buildKmp(char[] chars) {
        int[] nexts = new int[chars.length];
        nexts[0] = -1;
        int index = 0;
        for (int i = 2; i < chars.length; i++) {
            if (chars[i - 1] == chars[index]) {
                nexts[i] = ++index;
            } else {
                if (nexts[index] != -1) {
                    index = nexts[index];
                    i--;
                } else {
                    index = 0;
                }
            }
        }
        return nexts;
    }
}
