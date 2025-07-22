package huweiA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ode0088 {

    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\[\\d+,\\d+]");
        Matcher m = p.matcher(s);
        HashSet<Integer> set = new HashSet<>();
        while (m.find()) {
            String ss1 = m.group();
            ss1 = ss1.trim().substring( 1, ss1.length() - 1 );
            String[] sss = ss1.split(",");
            int a = Integer.parseInt( sss[0] );
            int b = Integer.parseInt( sss[1] );
            set.add( a );
            set.add( b );
            List<Integer> list = map.getOrDefault( a , new ArrayList<>() );
            list.add( b );
            map.put( a, list );
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort( list );
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            HashSet<Integer> coll = new HashSet<>();
            getAp(coll,i, i, false);
            sb.append(coll.size()).append(',');
        }
        System.out.println('[' + sb.substring(0, sb.length() - 1) + ']');
    }

    private static void getAp(HashSet<Integer> coll, Integer i, Integer origin, boolean sub) {
        if (!map.containsKey(i) || (sub && i.equals(origin))) {
            return;
        }
        for (Integer j : map.get(i)) {
            if (j < origin) {
                coll.add( j );
            }
            getAp(coll, j, origin, true );
        }
    }
}
