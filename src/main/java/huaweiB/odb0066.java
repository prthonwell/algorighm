package huaweiB;

import java.util.*;

public class odb0066 {

    public static class Card {
        String value;
        String color;

        Card( String value, String Color ) {
            this.value = value;
            this.color = Color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int n = line1.length;
        Card[] cards = new Card[n];
        HashMap< String, HashSet<Card> > map = new HashMap<> ();
        for ( int i = 0; i < n; i++ ) {
            Card card = new Card( line1[i], line2[i] );
            map.putIfAbsent(line1[i], new HashSet<>());
            map.get(line1[i]).add( card );
            map.putIfAbsent(line2[i], new HashSet<>());
            map.get(line2[i]).add( card );
            cards[ i ] = card;
        }
        int[] res = new int[1];
        HashSet<Card> used = new HashSet<>();
        for ( int i = 0; i < n; i++ ) {
            Card c = cards[ i ];
            used.add( c );
            dfs(res, c, map, 0, used);
            used.remove( c );
        }
        System.out.println(res[0]);
    }

    private static void dfs(int[] res, Card card, HashMap<String, HashSet<Card>> map, int depth, HashSet<Card> used) {
        depth++;
        res[0] = Math.max( res[0], depth );
        for (Card c : map.getOrDefault( card.color, new HashSet<>() ) ) {
            if (used.contains( c )) {
                continue;
            }
            used.add( c );
            dfs(res, c, map, depth, used);
            used.remove( c );
        }
        for (Card c : map.getOrDefault( card.value, new HashSet<>() ) ) {
            if (used.contains( c )) {
                continue;
            }
            used.add( c );
            dfs(res, c, map, depth, used);
            used.remove( c );
        }
    }
}
