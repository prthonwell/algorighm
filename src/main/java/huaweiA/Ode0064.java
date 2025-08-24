package huaweiA;

import java.util.*;

public class Ode0064 {

    public static void main(String[] args) {
        String s = "niger";
        int res = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            res = res * 26 + (s.charAt( i ) - 'a') + 1;
        }
        System.out.println( res );
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            System.out.println("a");
            return;
        }
        while (n > 0) {
            n--;
            int num = n % 26;
            n /= 26;
            int a = 'a';
            char cur = (char)(a + num);
            sb.append(cur);
        }
        System.out.println(sb.reverse());
    }
}
