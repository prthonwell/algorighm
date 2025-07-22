package huweiA;

import java.util.*;

public class Ode0115 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(ss[0]);
        String join = String.join("", ss).toUpperCase();
        int count = n;
        for (int i = ss[0].length(); i < join.length(); i++) {
            if (count == n) {
                sb.append("-");
                count = 0;
            }
            sb.append(join.charAt(i));
            count++;
        }
        System.out.println(sb.toString());
    }
}
