package huaweiA;

import java.util.*;

public class Ode0003 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] nums = new int[n];
        for ( int i = 0; i < n; i++ ) {
            weights[i] = sc.nextInt();
        }
        for ( int i = 0; i < n; i++ ) {
            nums[i] = sc.nextInt();
        }
        int[][] fm = new int[n][2];
        for ( int i = 0; i < n; i++ ) {
            fm[i][1] = nums[i];
            fm[i][0] = weights[i];
        }
        Arrays.sort( fm, ( a, b ) -> a[0] - b[0] );
        HashSet<Integer> res = new HashSet<>();
        res.add( 0 );
        for ( int i = 0; i < n; i++ ) {
            int num = fm[i][1];
            int weight = fm[i][0];
            ArrayList<Integer> curNums = new ArrayList<>();
            for ( int j = 1; j <= num; j++ ) {
                for ( int cur : res) {
                    curNums.add( cur + weight * j );
                }
            }
            res.addAll(curNums);
        }
        System.out.println( res.size() );
    }
}