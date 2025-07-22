package huweiB;

import java.util.*;

public class odb0027 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring( 1, s.length() - 1 );
        List<List<String>> list = new ArrayList<>();
        for ( int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '[') {
                int start = i + 1;
                while (s.charAt(i) != ']') {
                    i++;
                }
                List<String> cur = new ArrayList<>();
                String str = s.substring( start, i );
                Collections.addAll(cur, str.split(","));
                list.add( cur );
            }
        }
        int n = sc.nextInt();
        for ( int i = 0; i < n; i++ ) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            if (!list.get(x1).get(y1).equals(list.get(x2).get(y2))) {
                sc.close();
                System.out.println("NO");
                return;
            }
        }
        sc.close();
        System.out.println("OK");
    }
}
