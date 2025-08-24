package huaweiA;

import java.util.Scanner;

public class Ode0041 {
    static int[] move = new int[] { 1, 3 };
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[ Math.max( n + 1, 4 ) ];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        int index = 4;
        while ( index <= n ) {
            dp[index] = dp[index - 1] + dp[index - 3];
            index++;
        }
        System.out.println( dp[n] );
    }
}
