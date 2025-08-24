package huaweiA;

import java.util.*;

public class Ode0069 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int m = sc.nextInt();
        HashMap< Integer, int[] > map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            map.put( num, new int[]{ 0 , 0 } );
            list.add( num );
        }
        sc.close();
        int[] cur = new int[] { 0, 2 };
        for (int i = 0; i < n; i++) {
            int tag = 0;
            int j = i;
            while (i < Math.min(n, j + 2)) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    tag = tag * 16 + (c - '0');
                } else {
                    tag = tag * 16 + (c - 'A') + 10;
                }
                i++;
            }
            j = i;
            int len = 0;
            while (i < Math.min(n, j + 2)) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    len = len * 16 + c - '0';
                } else {
                    len = len * 16 + c - 'A' + 10;
                }
                i++;
            }
            if (i + len * 2 > n) break;
            cur[0] = len;
            if (map.containsKey(tag)) {
                map.get(tag)[0] = cur[0];
                map.get(tag)[1] = cur[1];
            }
            cur[1] = cur[1] + len + 2;
            i += len * 2 - 1;
        }
        for (Integer key : list) {
            System.out.println(map.get(key)[0] + " " + map.get(key)[1]);
        }
    }
}
