package huweiA;

import java.util.*;

public class Ode0097 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add( -1 );
        String str = sc.nextLine();
        sc.close();
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            list.add(Integer.parseInt(strs[i]));
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, list, result, new ArrayList<Integer>());
        result.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(o1.size() - 1) - o2.get(o2.size() - 1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : result.get(0)) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int i, List<Integer> list, List<List<Integer>> result, List<Integer> path) {
        if (i >= list.size() || list.get(i) == -1) {
            return;
        }
        path.add(list.get(i));
        if ((2*i >= list.size() || list.get(2*i) == -1)
                && (2*i + 1 >= list.size() || list.get(2*i + 1) == -1)) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(2*i, list, result, path);
        dfs(2*i+1, list, result, path);
        path.remove(path.size() - 1);
    }
}
