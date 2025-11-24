package huaweiC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class odc0001 {


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String[] ss = sc.nextLine().split(",");
        String number = sc.nextLine();
        sc.close();
        List<String> result = new ArrayList<>();
        out: for (String s : ss) {
            for (int i = 0; i < s.length() && i < number.length(); i++) {
                char sChar = s.charAt(i), numberChar = number.charAt(i);
                if (sChar == numberChar || (sChar == '?' && i % 2 == 1)) {
                    continue;
                } else if (sChar == '*') {
                    // pattern的最后一位*肯定可以匹配完成
                    if (i == s.length() - 1) {
                        result.add(s);
                        continue out;
                    }
                    // pattern的后缀必须完整匹配
                    String suffix = s.substring(i + 1);
                    int pos = suffix.length() - 1;
                    for (int j = number.length() - 1; j >= i && pos >= 0; j--, pos--) {
                        char sp = suffix.charAt(pos), sj = number.charAt(j);
                        if (sp == sj) continue;
                        else if (sp == '?') {
                            if (j % 2 == 0) break;
                        } else break;
                    }
                    if (pos < 0) result.add(s);
                    continue out;
                } else {
                    continue out;
                }
            }
            if (s.length() == number.length() || (s.length() == 16 && s.charAt(15) == '*')) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            System.out.println("null");
        } else {
            StringJoiner sj = new StringJoiner(",");
            for (String s : result) {
                sj.add(s);
            }
            System.out.println(sj);
        }
    }

}
