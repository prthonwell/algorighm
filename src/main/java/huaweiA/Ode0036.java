package huaweiA;

import java.util.*;

public class Ode0036 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split( "," );
        int n = ss.length;
        HashMap< String, Integer > map = new HashMap<>();
        for ( int i = 0; i < n; i++ ) {
            map.put( ss[i], map.getOrDefault( ss[i], 0 ) + 1 );
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>( map.entrySet() );
        list.sort( Comparator.comparingInt( Map.Entry::getValue ) );
        int count = 0, index = list.size() - 1, res = 0;
        while ( count < (n + 1) / 2 ) {
            count += list.get( index ).getValue();
            index--;
            res++;
        }
        System.out.println(res);
    }

}