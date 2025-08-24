package huaweiB;

import java.util.*;

public class odb0048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        cut(X, res);
        res.sort(Integer::compareTo);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == 2 && i + 1 < res.size() && res.get(i + 1) == 2) {
                ans.add(4);
                i++;
            } else {
                ans.add(res.get(i));
            }
        }
        ans.sort(Integer::compareTo);
        StringJoiner sj = new StringJoiner(" ");
        for (Integer i : ans) sj.add(i + "");
        System.out.println(sj.toString());
        sc.close();
    }

    private static void cut(int x, List<Integer> res) {
        if (x <= 4) {
            res.add(x);
            return;
        }
        cut(x / 2, res);
        cut(x - (x / 2) ,res);
    }
}
