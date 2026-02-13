package leetCode.from3701to3800;

import java.util.*;

class LongestBalanced {
    public int longestBalanced(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1 || s.length() == 2) return s.length();
        int n = s.length();
        int[] statue = new int[3];
        HashMap<String, Integer> map = new HashMap<>();
        List<String> firstDiffs = getDiffs(statue);
        for (String str : firstDiffs) {
            map.put(str, 0);
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            statue[c - 'a']++;
            List<String> diffs = getDiffs(statue);
            for (String diff : diffs) {
                if (map.containsKey(diff)) {
                    res = Math.max(res,i + 1 - map.get(diff));
                } else {
                    map.put(diff, i + 1);
                }
            }
        }
        return res;
    }

    private List<String> getDiffs(int[] statue) {
        List<String> diffs = new ArrayList<>();
        diffs.add("x" + "_" + statue[1] + "_" + statue[2]);
        diffs.add(statue[0] + "_" + "x" + "_" + statue[2]);
        diffs.add(statue[0] + "_" + statue[1] + "_" + "x");
        diffs.add("x" + "_" + "x+" + (statue[1] - statue[0]) + "_" + statue[2]);
        diffs.add(statue[0] + "_" + "x" + "_" + "x+" + (statue[2] - statue[1]));
        diffs.add("x" + "_" + statue[1] + "_" + "x+" + (statue[2] - statue[0]));
        diffs.add("x" + "_" + "x+" + (statue[1] - statue[0]) + "_" + "x+" + (statue[2] - statue[1]));
        return diffs;
    }

    public int longestBalanced2(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1 || s.length() == 2) return s.length();
        int n = s.length(), res = 1;
        // 处理单个字符
        int len = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == s.charAt(i - 1)) {
                len++;
            } else {
                res = Math.max(res, len);
                len = 1;
            }
        }
        res = Math.max(res, len);

        // 处理两个字符
        String[] ASplit = s.split("a");
        res = Math.max(res, findRes(ASplit, 'b', 'c'));
        String[] BSplit = s.split("b");
        res = Math.max(res, findRes(BSplit, 'a', 'c'));
        String[] CSplit = s.split("c");
        res = Math.max(res, findRes(CSplit, 'a', 'b'));

        // 处理3个字符
        int[] statue = new int[3];
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0_0", 0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            statue[c - 'a']++;
            String diff = (statue[1] - statue[0]) + "_" + (statue[2] - statue[1]);
            if (map.containsKey(diff)) {
                res = Math.max(res,i + 1 - map.get(diff));
            } else {
                map.put(diff, i + 1);
            }

        }
        return res;
    }

    private int findRes(String[] aSplit, char b, char c) {
        int res = 0;
        for (String str : aSplit) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            int[] spec = new int[2];
            int n = str.length();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == b) {
                    spec[0]++;
                } else {
                    spec[1]++;
                }
                int diff = spec[1] - spec[0];
                if (map.containsKey(diff)) {
                    res = Math.max(res,i + 1 - map.get(diff));
                } else {
                    map.put(diff, i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestBalanced solution = new LongestBalanced();
        System.out.println(solution.longestBalanced2("ccaca"));
    }
}