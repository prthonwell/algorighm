package huaweiA;

import java.util.*;

public class Ode0007 {

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int max = 0;
        List<Integer> arr = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            int a = sc.nextInt();
            arr.add( a );
            sum += a;
            max = Math.max( a, max );
        }
        sc.close();
        arr.sort((a, b) -> b - a);
        for ( int i = max; i <= sum; i++ ) {
            if (sum % i == 0) {
                if (dfs(0, arr, new int[sum / i], i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    private static boolean dfs(int i, List<Integer> arr, int[] cups, int limit) {
        if (i == arr.size()) {
            return true;
        }
        for (int j = 0; j < cups.length; j++) {
            if (j != 0 && cups[j] == cups[j - 1]) continue;
            if (cups[j] + arr.get(i) <= limit) {
                cups[j] = cups[j] + arr.get(i);
                if (dfs(i + 1, arr, cups, limit)) return true;
                cups[j] = cups[j] - arr.get(i);
            }
        }
        return false;
    }
}