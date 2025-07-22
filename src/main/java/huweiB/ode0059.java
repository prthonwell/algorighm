package huweiB;

import java.util.*;

public class ode0059 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int res = 0, size = 0;
        boolean ordered = true;
        for (int i = 0; i < 2 * n; i++) {
            String line = sc.nextLine();
            if (line.charAt(0) == 'h') {
                if (size > 0) ordered = false;
                size++;
            } else if (line.charAt(0) == 't') {
                size++;
            } else {
                if (ordered) {
                    size--;
                } else {
                    res++;
                    ordered = true;
                    size--;
                }
            }
        }
        sc.close();
        System.out.println(res);
    }
}
