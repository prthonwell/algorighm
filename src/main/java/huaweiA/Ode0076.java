package huaweiA;

import java.util.*;

public class Ode0076 {

    static class data {
        int num = 0;
        char ch = ' ';
        data( int num, char ch ) {
            this.num = num;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = s1.length();
        int m = s2.length();
        int[] index1 = new int [1];
        int[] index2 = new int [1];
        data d1 = buildStr(s1, index1);
        data d2 = buildStr(s2, index2);
        int miss = 0, total = d1.num;
        while (d1.num != 0 || d2.num != 0 || index1[0] < n) {
            if (d1.num == 0) {
                d1 = buildStr(s1, index1);
                total += d1.num;
                index1[0]++;
            }
            if (d2.num == 0) {
                d2 = buildStr(s2, index2);
                index2[0]++;
            }
            int min = Math.min(d1.num, d2.num);
            if (d1.ch != d2.ch) {
                miss += min;
            }
            d1.num -= min;
            d2.num -= min;
        }
        System.out.println(miss + "/" + total);
    }

    private static data buildStr(String s, int[] index) {
        int num = 0;
        while (s.charAt(index[0]) > '0' && s.charAt(index[0]) <= '9') {
            num = num * 10 + (s.charAt(index[0]) - '0');
            index[0]++;
        }
        return new data(num, s.charAt(index[0]));
    }
}
