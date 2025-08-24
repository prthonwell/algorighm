package huaweiA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ode0075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\(\\d+,\\d+\\)");
        Matcher m = p.matcher(s);
        List<int[]> list = new ArrayList<>();
        HashMap<Integer, HashSet> map = new HashMap<>();
        while (m.find()) {
            String cur = m.group();
            cur = cur.substring(1, cur.length() - 1);
            String[] split = cur.split(",");
            int[] arr = new int[] { Integer.parseInt(split[0]), Integer.parseInt(split[1]) };
            if (!map.containsKey(arr[1]) || !map.get(arr[1]).contains(arr[0])) {
                HashSet set = map.getOrDefault(arr[1], new HashSet());
                set.add(arr[0]);
                map.put(arr[1], set);
                list.add(arr);
            }
        }
        list.sort( (a,b) -> b[1] - a[1] );
        StringBuilder sb = new StringBuilder();
        for (int[] arr : list) {
            sb.append(arr[0]).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
