package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0077 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> res = new ArrayList<>();
        int total = 0;
        int[] quack = new int[5];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'q') quack[0]++;
            else if (c == 'u') quack[1] = Math.min(quack[0], quack[1] + 1);
            else if (c == 'a') quack[2] = Math.min(quack[1], quack[2] + 1);
            else if (c == 'c') quack[3] = Math.min(quack[2], quack[3] + 1);
            else if (c == 'k') {
                quack[4] = Math.min(quack[3], quack[4] + 1);
                if (quack[4] == 1) {
                    total++;
                    res.add(quack[0]);
                    for (int j = 0; j < 5; j++) {
                        quack[j]--;
                    }
                }
            } else {
                System.out.println(-1);
                return;
            }
        }
        if (total == 0) {
            System.out.println(-1);
            return;
        }
        int max = 0;
        for (int i = 0; i < res.size(); i++) {
            if (i + res.get(i) < total) {
                max = Math.max(max, res.get(i));
            } else {
                max = Math.max(max, total - i);
            }
        }
        System.out.println(max);
    }
}
