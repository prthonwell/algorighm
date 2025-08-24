package huaweiB;

import java.util.*;

public class odb0031 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.put( a, map.getOrDefault( a , 0 ) + 1 );
        }
        int limit = sc.nextInt();
        List<Map.Entry<Integer, Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= limit) {
                res.add( entry );
            }
        }
        sc.close();
        System.out.println(res.size());
        res.sort( (a, b) -> b.getValue() == a.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        for (Map.Entry<Integer,Integer> integer : res) {
            System.out.println(integer.getKey());
        }
    }
}
