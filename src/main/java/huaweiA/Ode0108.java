package huaweiA;

import java.util.*;

public class Ode0108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        sc.close();
        Arrays.sort( ss , new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    if (o1.charAt(i) > o2.charAt(i)) return 1;
                    else if (o1.charAt(i) < o2.charAt(i)) return -1;
                }
                return o1.length() - o2.length();
            }
        });
        HashSet<String> distinct = new HashSet<>();
        List<String> res = new ArrayList<>();
        dfs(0, n, ss, res, distinct, new HashSet<Integer>(), new StringBuilder());
        for (String str : res) {
            System.out.println(str);
        }
    }

    private static void dfs(int count, int n, String[] ss, List<String> res, HashSet<String> distinct, HashSet<Integer> used, StringBuilder sb) {
        if (count == n) {
            if (distinct.contains(sb.toString())) return;
            res.add(sb.toString());
            distinct.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used.contains(i)) continue;
            used.add(i);
            sb.append(ss[i]);
            dfs(count + 1, n, ss, res, distinct, used, sb);
            sb.delete(sb.length() - ss[i].length(), sb.length());
            used.remove(i);
        }
    }
}
