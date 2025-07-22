package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int index1 = 0, index2 = 0;
        for (; index2 < c2.length; index2++) {
            if (c2[index2] == c1[index1]) {
                index1++;
                if (index1 == c1.length) {
                    break;
                }
            }
        }
        sc.close();
        if (index2 != c2.length) {
            System.out.println(index2);
        } else {
            System.out.println(-1);
        }
    }
}
