package huweiA;

import java.util.*;

public class Ode0090 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String ss1 : ss) {
            list.add(Integer.parseInt(ss1));
        }
        int n = sc.nextInt();
        sc.close();
        list.sort(Integer::compareTo);
        List<List<Integer>> res = new ArrayList<>();
        all(res, list, 0, n, new ArrayList<>());
        if (res.isEmpty()) {
            System.out.println("None");
            return;
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int index = 0;
                while (index < o1.size() && index < o2.size()) {
                    if (!Objects.equals(o1.get(index), o2.get(index))) {
                        return o1.get(index) - o2.get(index);
                    }
                    index++;
                }
                return o1.size() - o2.size();
            }
        });
        for (List<Integer> cur : res) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : cur) {
                sb.append(integer).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    private static void all(List<List<Integer>> res, List<Integer> list, int index, int n, ArrayList<Integer> path) {
        if (path.size() >= n) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < list.size(); i++) {
            path.add(list.get(i));
            all(res, list, i + 1, n, path);
            path.remove(path.size() - 1);
        }
    }
}
