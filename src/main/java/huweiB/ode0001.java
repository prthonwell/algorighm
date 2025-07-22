package huweiB;

import java.util.*;

public class ode0001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String[] str = sc.nextLine().split("#");
        if (str.length != 4) {
            System.out.println("invalid IP");
            return;
        }
        long res = 0;
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("invalid IP");
                return;
            }
            if (num < 0 || num > 255 || (i == 0 && num > 128)) {
                System.out.println("invalid IP");
                return;
            }
            res = res * 256 + num;
        }
        System.out.println(res);
        sc.close();
    }
}
