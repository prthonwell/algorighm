package from121to140;

import java.util.ArrayList;
import java.util.List;

class Partition {
    public List<List<String>> partition(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
        List<List<String>>[] resDp = new ArrayList[n];
        for (int i = n - 1; i >= 0; i--) {
            List<List<String>> cur = new ArrayList<>();
            for (int j = i; j < n; j++) {
                if (dp[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(i, j + 1));
                    if (j + 1 < n) {
                        for (List<String> l : resDp[j + 1]) {
                            int count = l.size();
                            list.addAll(l);
                            cur.add(new ArrayList<>(list));
                            while (count-- > 0) {
                                list.remove(list.size() - 1);
                            }
                        }
                    } else {
                        cur.add(list);
                    }
                }
            }
            resDp[i] = cur;
        }
        return resDp[0];
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.partition("aab"));
    }
}