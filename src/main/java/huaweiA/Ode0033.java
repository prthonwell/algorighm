package huaweiA;

import java.util.*;

public class Ode0033 {
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
        sc.nextLine();
        String lines = sc.nextLine();
        sc.close();
        String[] words = lines.split( " " );
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for ( int i = 0; i < words.length; i++ ) {
            String word = words[i];
            if ( map.containsKey( word ) ) {
                HashSet< String > fathers = map.get( word );
                for ( String father : fathers ) {
                    if (set.contains(father)) {
                        words[i] = "";
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) continue;
            sb.append(word).append(' ');
        }
        System.out.println( sb.substring( 0, sb.length() - 1 ) );
    }

}