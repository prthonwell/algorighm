package huaweiB;

import java.util.*;

public class odb0006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ints = s.split(",");
        Arrays.sort( ints , new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo( o2 );
                }
                return o1.length() - o2.length();
            }
        });
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < ints.length && index < 3) {
            res.add(ints[index]);
            index++;
        }
        res.sort( String::compareTo );
        StringBuilder sb = new StringBuilder();
        for (String ss : res) {
            sb.append(ss);
        }
        sc.close();
        System.out.println(sb.toString());
    }
}
