package huaweiB;

import java.util.*;

public class ode0019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str[0].length(), m = str[1].length();
        if (n > m) {
            System.out.println(-1);
            return;
        }
        int[] spec = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = str[0].charAt(i);
            spec[ch - 'a']++;
        }
        int index1 = 0, index2 = 0;
        int[] newSpec = new int[26];
        while (index2 < n) {
            char ch = str[1].charAt(index2);
            newSpec[ch - 'a']++;
            index2++;
        }
        if (check(spec, newSpec)) {
            System.out.println(0);
            return;
        }
        while (index2 < m) {
            char add = str[1].charAt(index2);
            char remove = str[1].charAt(index1);
            newSpec[add - 'a']++;
            newSpec[remove - 'a']--;
            index2++;
            index1++;
            if (check(spec, newSpec)) {
                System.out.println(index1);
                return;
            }
        }
        System.out.println(-1);
        sc.close();
    }

    private static boolean check(int[] spec, int[] newSpec) {
        int n = spec.length;
        for (int i = 0; i < n; i++) {
            if (spec[i] != newSpec[i]) {
                return false;
            }
        }
        return true;
    }
}
