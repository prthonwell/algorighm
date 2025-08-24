package huaweiB;

import java.util.*;

public class odb0036 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        int[] spec = new int[10];
        int count = 0, l = 0, r = 0, res = 0;
        while (r < s.length()) {
            if (!Isfull(spec)) {
                char c = s.charAt(r);
                if (c >= '0' && c <= '9') {
                    spec[c - '0']++;
                } else {
                    count++;
                }
                r++;
            } else if (count > k) {
                char c = s.charAt(l);
                if (c >= '0' && c <= '9') {
                    spec[c - '0']--;
                } else {
                    count--;
                }
                l++;
            } else if (count == k) {
                int index = 0;
                while (index + r < s.length() && s.charAt(index + r) >= '0' && s.charAt(index + r) <= '9') {
                    index++;
                }
                res += index + 1;
                if (s.charAt(l) >= '0' && s.charAt(l) <= '9') {
                    spec[s.charAt(l) - '0']--;
                } else {
                    count--;
                }
                l++;
            } else {
                char c = s.charAt(r);
                if (c >= '0' && c <= '9') {
                    spec[c - '0']++;
                } else {
                    count++;
                }
                r++;
            }
        }
        if (Isfull(spec) && count == k) {
            res++;
        }
        System.out.println(res);
        sc.close();
    }

    private static boolean Isfull(int[] spec) {
        for (int i = 0; i < 10; i++) {
            if (spec[i] == 0) return false;
        }
        return true;
    }
}
