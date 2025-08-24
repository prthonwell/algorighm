package huaweiA;

import java.util.*;

public class Ode0018 {
    public static void main( String[] args ) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner( System.in );
        String newspaper = sc.nextLine();
        String[] strs = newspaper.split(" ");
        for ( String s : strs ) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                cur |= 1 << (s.charAt(i) - '0');
            }
            if (map.containsKey( cur ) ) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        boolean flag = true;
        String anonymousLetter = sc.nextLine();
        String[] strs2 = anonymousLetter.split(" ");
        for ( String s : strs2 ) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                cur |= 1 << (s.charAt(i) - '0');
            }
            if (!map.containsKey( cur ) ) {
                flag = false;
                break;
            } else {
                if (map.get(cur) == 1) {
                    map.remove( cur );
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
            }
        }
        System.out.println(flag);
    }
}