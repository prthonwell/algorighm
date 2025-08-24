package huaweiB;

import java.util.*;

public class ode0174 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split("");
        int[] spec = new int[13];
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("0")) spec[9]++;
            else if (ss[i].equals("J")) spec[10]++;
            else if (ss[i].equals("Q")) spec[11]++;
            else if (ss[i].equals("K")) spec[12]++;
            else {
                spec[Integer.parseInt(ss[i]) - 1]++;
            }
        }
        sc.close();
        int res = dfs(spec, 0);
        System.out.println(res);
    }

    private static int dfs(int[] spec, int i) {
        if (i == 13) return 0;
        if (spec[i] == 0) return dfs(spec, i + 1);
        int res = 0;
        if (i <= 5 && spec[i + 1] > 0 && spec[i + 2] > 0 && spec[i + 3] > 0 && spec[i + 4] > 0) {
            spec[i]--;
            spec[i + 1]--;
            spec[i + 2]--;
            spec[i + 3]--;
            spec[i + 4]--;
            res = Math.max(res, dfs(spec, i) + (i + i + 6) * 5);
            spec[i]++;
            spec[i + 1]++;
            spec[i + 2]++;
            spec[i + 3]++;
            spec[i + 4]++;
        }
        if (spec[i] == 1) {
            res = Math.max(res, dfs(spec, i + 1) + i + 1);
        } else if (spec[i] == 2 || spec[i] == 3) {
            res = Math.max(res, dfs(spec, i + 1) + (i + 1) * spec[i] * 2);
        } else {
            res = Math.max(res, dfs(spec, i + 1) + (i + 1) * spec[i] * 3);
        }
        return res;

    }
}
