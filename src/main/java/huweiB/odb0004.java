package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(arr[i]);
        }
        String s = stringBuilder.toString();
        out : for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                String cur = s.substring(0, i);
                int index = i;
                while (index + i <= n) {
                    String str = s.substring(index, index + i);
                    if (!str.equals(cur)) {
                        continue out;
                    }
                    index += i;
                }
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int j = 0; j < cur.length(); j++) {
                    stringBuilder1.append(cur.charAt(j)).append(' ');
                }
                System.out.println(stringBuilder1.substring(0, stringBuilder1.length() - 1));
                return;
            }
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder1.append(arr[i]).append(' ');
        }
        System.out.println(stringBuilder1.substring(0, stringBuilder1.length() - 1));
    }
}
