package huaweiA;

import java.util.*;

public class Ode0027 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for ( int i = 0; i < n; i++ ) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort( arr, ( a, b ) -> a[0] - b[0] );
        if ( arr.length == 0) {
            System.out.println("None");
            return;
        }
        ArrayList<int[]> covered = new ArrayList<>();
        covered.add( arr[0] );
        ArrayList<int[]> layered = new ArrayList<>();
        int index = 0;
        for ( int i = 1; i < n; i++ ) {
            int[] cur = covered.get(index);
            int l = arr[i][0], r = arr[i][1], right = cur[1];
            if (l <= right) {
                layered.add(new int[] { l, Math.min(r, right) });
                cur[1] = Math.max(r, right);
            } else {
                covered.add(arr[i]);
                index++;
            }
        }
        if (layered.isEmpty()) {
            System.out.println("None");
            return;
        }
        ArrayList<int[]> res = new ArrayList<>();
        res.add( layered.get( 0 ) );
        index = 0;
        for ( int i = 1; i < layered.size(); i++ ) {
            int[] cur = res.get(index);
            int[] layer = layered.get( i );
            if (layer[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], layer[1]);
            } else {
                res.add( layer );
                index++;
            }
        }
        for (int[] a : res) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}