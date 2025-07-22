package huweiB;

import java.util.*;

public class ode0041 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int t = sc.nextInt();
        out :for ( int i = 0; i < t; i++ ) {
            int n = sc.nextInt(), k = sc.nextInt();
            sc.nextLine();
            String bi = sc.nextLine();
            if ( k > n / 2 ) {
                System.out.println("Alice");
            } else {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (bi.charAt(j) == '1') {
                        count++;
                        if (count > k) {
                            System.out.println("Bob");
                            continue out;
                        }
                    }
                }
                System.out.println("Alice");
            }
        }
    }

}
