package huaweiB;

import java.util.*;

public class ode0034 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap< String, Integer> map = new HashMap<>();
        while ( sc.hasNextLine() ) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            if (line.charAt(0) >= '0' && line.charAt(0) <= '9') {
                List<Map.Entry<String, Integer>> list = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : map.entrySet()) list.add(entry);
                list.sort(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue() != o2.getValue()
                                ? o2.getValue() - o1.getValue()
                                : o1.getKey().compareTo(o2.getKey());
                    }
                });
                StringJoiner sj = new StringJoiner(",");
                int num = Integer.parseInt(line);
                for (int i = 0; i < num; i++) {
                    sj.add(list.get(i).getKey());
                }
                System.out.println(sj.toString());
            } else {
                map.put( line, map.getOrDefault( line, 0 ) + 1 );
            }
        }
        sc.close();
    }
}
