package huaweiB;

import java.util.*;

public class odb0057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String BI1 = sc.nextLine();
        String BI2 = sc.nextLine();
        long a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < N; i++) {
            char c1 = BI1.charAt(i);
            char c2 = BI2.charAt(i);
            if (c1 == '0' && c2 == '0') {
                a++;
            } else if (c1 == '0' && c2 == '1') {
                b++;
            } else if (c1 == '1' && c2 == '0') {
                c++;
            } else {
                d++;
            }
        }
        long res = a * (c + d) + b * c;
        System.out.println(res);
        sc.close();
    }
}
