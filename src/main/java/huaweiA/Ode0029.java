package huaweiA;

import java.util.*;

public class Ode0029 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ss = new String[n];
        for ( int i = 0; i < n; i++ ) {
            ss[i] = sc.next();
        }
        sc.close();
        int[][] arr = new int[n][2];
        for ( int i = 0; i < n; i++ ) {
            String[] lr = ss[i].split(",");
            arr[i][0] = Integer.parseInt(lr[0]);
            arr[i][1] = Integer.parseInt(lr[1]);
        }
        Arrays.sort( arr, ( a, b ) -> a[0] - b[0] );
        ArrayList<int[]> map = new ArrayList<>();
        int index = 0;
        map.add( new int[]{ arr[0][0], arr[0][1] });
        for ( int i = 1; i < n; i++ ) {
            int[] cur = map.get( index );
            if ( arr[i][0] <= cur[1]) {
                cur[1] = Math.max( arr[i][1], cur[1] );
            } else {
                map.add(arr[i]);
                index++;
            }
        }
        index = 0;
        int count = 0;
        for (int[] cur : map) {
            int l = cur[0], r = cur[1];
            int max = l;
            while (index < n && arr[index][0] == l) {
                max = Math.max( arr[index][1], max );
                index++;
            }
            count++;
            while (max != r) {
                int right = max;
                while (index < n && arr[index][0] <= right) {
                    max = Math.max( arr[index][1], max );
                    index++;
                }
                count++;
            }
        }
        System.out.println( count );
    }
}