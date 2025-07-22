package huweiA;

import java.util.*;

public class Ode0021 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        String word = sc.nextLine();
        char[] ss = s.toCharArray();
        char[] ws = word.toCharArray();
        int n = ss.length;
        int m = ws.length, index = m;
        if (m > n) {
            System.out.println(0);
            return;
        }
        int[] wordNum = new int[128];
        int[] compare = new int[128];
        int count = 0;
        for ( int i = 0; i < m; i++) {
            wordNum[ws[i] - 'a']++;
            compare[ss[i] - 'a']++;
        }
        if (check(wordNum, compare)) count++;
        while (index < n) {
            wordNum[ss[index] - 'a']++;
            wordNum[ss[index - m] - 'a']--;
            if (check(wordNum, compare)) count++;
            index++;
        }
        System.out.println(count);
    }

    private static boolean check(int[] wordNum, int[] compare) {
        boolean flag = true;
        for (int i = 0; i < wordNum.length; i++) {
            if (wordNum[i] != compare[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}