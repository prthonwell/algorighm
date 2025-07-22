package huweiA;

import java.util.*;

public class Ode0050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sNum = Integer.parseInt(s);
        sc.close();
        if (s.equals("1") || s.equals("2") || s.equals("3")) {
            System.out.println(s);
            return;
        }
        int n = s.length();
        while (n < 9) {
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) {
                    start.append(1);
                } else {
                    start.append(0);
                }
                end.append(9);
            }
            String cur = start.toString();
            String ed = end.toString();
            int curN = Integer.parseInt(cur);
            while (curN < sNum) {
                cur = add(cur);
                curN = Integer.parseInt(cur);
            }
            while (!cur.equals(ed)) {
                if ((cur.charAt(0) - '0') % 2 != 0 && isSU(cur)) {
                    System.out.println(cur);
                    return;
                }
                cur = add(cur);
            }

            n++;
        }

    }

    private static String add(String cur) {
        int n = cur.length();
        char[] chars = cur.toCharArray();
        int mid = (n - 1) / 2;
        int l = mid,r;
        if (n % 2 == 0) {
            r = mid + 1;
        } else {
            r = mid;
        }
        while (chars[l] == '9') {
            l--;
            r++;
        }
        int num = (cur.charAt(l) - '0');
        num++;
        chars[r] = chars[l] = String.valueOf(num).charAt(0);
        for (int i = l + 1; i < r; i++) {
            chars[i] = '0';
        }
        return String.valueOf(chars);
    }

    public static boolean isSU(String cur) {
        int num = Integer.parseInt(cur);
        for (int i = 3; i * i < num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
