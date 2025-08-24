package huaweiA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ode0089 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\[\\d+,\\d+]");
        Matcher m = p.matcher(s);
        List<int[]> specs = new ArrayList<>();
        while (m.find()) {
            String ss1 = m.group();
            ss1 = ss1.trim().substring( 1, ss1.length() - 1 );
            String[] sss = ss1.split(",");
            int a = Integer.parseInt( sss[0] );
            int b = Integer.parseInt( sss[1] );
            specs.add(new int[]{ a, b });
        }
        if (specs.isEmpty()) {
            sc.close();
            System.out.println(0);
            return;
        }
        specs.sort( (a, b) -> a[0] - b[0] );
        List<Integer> spreads = new ArrayList<>();
        int right = specs.get(0)[1];
        for (int i = 1 ; i < specs.size() ; i++) {
            if (right < specs.get(i)[0]) {
                spreads.add(specs.get(i)[0] - right);
            }
            right = Math.max(right, specs.get(i)[1]);
        }
        s = sc.nextLine();
        if (s.trim().equals("[]")) {
            sc.close();
            System.out.println(spreads.size() + 1);
            return;
        }
        sc.close();
        s = s.trim().substring( 1, s.length() - 1 );
        String[] ss = s.split(",");
        List<Integer> connectors = new ArrayList<>();
        for (String ss1 : ss) {
            connectors.add( Integer.parseInt( ss1 ) );
        }

        connectors.sort(Integer::compareTo);
        spreads.sort(Integer::compareTo);
        while (!spreads.isEmpty() && !connectors.isEmpty()) {
            if (connectors.remove(0) >= spreads.get(0)) {
                spreads.remove(0);
            }
        }
        System.out.println(spreads.size() + 1);
    }
}
