package leetCode.from900to1000;

import java.util.*;

public class MovesToStamp {
    public int[] movesToStamp(String stamp, String target) {
        int n = stamp.length();
        int m = target.length();
        char[] targets = target.toCharArray();
        int changed = 0;
        Deque<List<Integer>> stack = new ArrayDeque<>();
        while (changed < m) {
            int l = 0;
            int r = 0;
            int count = 0;
            while (r < n) {
                if (targets[r++] != '?') count++;
            }
            List<Integer> list = new ArrayList<>();
            while (r < m) {
                if (count > 0 && compare(targets, l, r, stamp)) {
                    changed += count;
                    list.add(l);
                    l = l + n;
                    r = l;
                    count = 0;
                    while (r < m && r < l + n) {
                        if (targets[r++] != '?') count++;
                    }
                    continue;
                }
                if (changed == m) break;
                if (targets[r++] != '?') count++;
                if (targets[l++] != '?') count--;
            }
            if (count > 0 && compare(targets, l, r, stamp)) {
                changed += count;
                list.add(l);
            }
            if (list.isEmpty()) break;
            stack.push(list);
            for (Integer i : list) {
                for (int j = i; j < i + n; j++) {
                    if (targets[j] != '?') targets[j] = '?';
                }
            }
        }
        if (changed < m) return new int[0];
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.addAll(stack.poll());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean compare(char[] targets, int l, int r, String stamp) {
        if (r - l != stamp.length()) return false;
        for (int i = l; i < r; i++) {
            if (targets[i] != '?' && targets[i] != stamp.charAt(i - l)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MovesToStamp movesToStamp = new MovesToStamp();
        int[] ints = movesToStamp.movesToStamp("ffc", "ffffcfffffffffc");
        System.out.println(Arrays.toString(ints));
    }
}
