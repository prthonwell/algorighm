package huweiA;

import java.util.*;

public class Ode0037 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split( "," );
        int l = sc.nextInt();
        sc.close();
        int n = ss.length;
        int index = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (index < Math.min( l + 1, n )) {
            if (map.containsKey( ss[index] )) {
                System.out.println(map.get( ss[index] ));
                return;
            }
            map.put( ss[index], index );
            index++;
        }
        for (; index < n; index++ ) {
            map.remove( ss[index - l - 1] );
            if (map.containsKey(ss[index])) {
                System.out.println(map.get( ss[index] ));
                return;
            }
            map.put( ss[index], index );
        }
        System.out.println(-1);
    }

}