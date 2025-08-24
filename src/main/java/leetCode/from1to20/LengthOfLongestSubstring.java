package leetCode.from1to20;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int res = 1, start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end++);
            while (set.contains(c)) {
                set.remove(s.charAt(start++));
            }
            set.add(c);
            res = Math.max(res, end - start);
        }
        return res;
    }
}
