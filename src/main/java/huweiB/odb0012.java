package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class odb0012 {

    static class work {
        String name;
        HashSet<work> depends;
        work( String name) {
            this.name = name;
            depends = new HashSet<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] ss = line.split(" ");
        HashMap<String, work> works = new HashMap<>();
        List<String> order = new ArrayList<>();
        for (String s : ss) {
            String[] split = s.split( "->" );
            if (!works.containsKey( split[0] )) {
                works.put( split[0], new work( split[0] ) );
                order.add( split[0] );
            }
            if (!works.containsKey( split[1] )) {
                works.put( split[1], new work( split[1] ) );
                order.add( split[1] );
            }
            works.get( split[0] ).depends.add( works.get( split[1] ) );
        }
        StringBuilder sb = new StringBuilder();
        order.sort(String::compareTo);
        HashSet<String> used = new HashSet<>();
        while ( used.size() != order.size() ) {
            List<work> finished = new ArrayList<>();
            for (int i = 0; i < order.size(); i++) {
                if (used.contains( order.get(i) )) continue;
                work cur = works.get( order.get( i ) );
                if ( cur.depends.isEmpty() ) {
                    finished.add( cur );
                }
            }
            for ( work work : finished ) {
                for (int i = 0; i < order.size(); i++) {
                    if (used.contains( order.get(i) )) continue;
                    works.get( order.get( i ) ).depends.remove( work );
                }
                used.add(work.name);
            }
            for ( work work : finished ) {
                sb.append( work.name ).append( " " );
            }
        }
        System.out.println( sb.substring( 0, sb.length() - 1 ) );
    }
}
