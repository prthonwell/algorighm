package huaweiC;

import java.util.Scanner;

public class odbc0004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        sc.close();
        int[] arr = new int[26];
        for ( int i = 0; i < s.length(); i++ ) {
            arr[s.charAt(i) - 'A']++;
        }
        long total = 0;
        for ( int i = 0; i < 26; i++ ) {
            total += arr[i];
        }
        total = getUpgrated(total - 1, total);
        for ( int i = 0; i < 26; i++ ) {
            if ( arr[i] > 0 ) {
                total /= getUpgrated(arr[i] - 1, arr[i]);
            }
        }
        System.out.println( total );
    }

    private static long getUpgrated(long current, long sum) {
        if (current < 2) return sum;
        else return getUpgrated(current - 1, sum * current);
    }

}
