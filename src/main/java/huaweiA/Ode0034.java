package huaweiA;

import java.util.*;

public class Ode0034 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap< String, HashSet< String > > map = new HashMap<>();
        for ( int i = 0; i < n; i++ ) {
            String key = sc.next();
            String value = sc.next();
            map.computeIfAbsent( value, k -> new HashSet<>() ).add( key );
        }
        sc.close();
        for ( Map.Entry< String, HashSet< String > > entry : map.entrySet() ) {
            String key = entry.getKey();
            HashSet< String > set = entry.getValue();
            for (String s : set) {
                if (!map.containsKey( s ) || !map.get( s ).contains( key ) ) {
                    System.out.println( "False" );
                    return;
                }
            }
        }
        System.out.println( "True" );
    }

}