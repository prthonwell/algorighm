package leetCode.from101to120;

import java.util.ArrayList;
import java.util.HashMap;

class NumDistinct {
    // 低内存占用率版
    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int n = sChars.length;
        int m = tChars.length;
        HashMap<Character, Integer> table = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> pos = new HashMap<>();
        int[] sq = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            if (!table.containsKey(tChars[i])) {
                table.put(tChars[i], 1);
                pos.put(tChars[i], new ArrayList<>());
            } else {
                sq[i] = table.get(tChars[i]);
                table.put(tChars[i], table.get(tChars[i]) + 1);

            }
            pos.get(tChars[i]).add(i);
        }
        HashMap<Character, int[]> count = new HashMap<>();
        for (char c : table.keySet()) {
            count.put(c, new int[table.get(c)]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (count.containsKey(sChars[i])) {
                ArrayList<Integer> list = pos.get(sChars[i]);
                for (int h = list.size() - 1; h >= 0; h--) {
                    int j = list.get(h);
                    if (j == m - 1) count.get(sChars[i])[sq[j]]++;
                    else {
                        count.get(sChars[i])[sq[j]] += count.get(tChars[j + 1])[sq[j + 1]];
                    }
                }
            }
        }
        return count.get(tChars[0])[table.get(tChars[0]) - 1];
    }

    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        NumDistinct n = new NumDistinct();
        System.out.println(n.numDistinct(s, t));
    }
}