package huweiA;

import java.util.*;

public class Ode0098 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) continue;
            int n = s.length();
            int index = 0;
            while (index < n) {
                if (index + 8 <= n) {
                    System.out.println(s.substring(index, index + 8));
                } else {
                    String s1 = s.substring(index, n);
                    int count = index + 8 - n;
                    System.out.print(s1);
                    while (count-- > 0) {
                        System.out.print('0');
                    }
                    System.out.println();
                }
                index += 8;
            }
        }
    }
}
