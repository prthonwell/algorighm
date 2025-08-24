package leetCode.from400to500;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] spec = new int[52];
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c < 'a') spec[c - 'A']++;
            else spec[c - 'a' + 26]++;
        }
        int res = 0;
        boolean rest = false;
        for (int i = 0; i < 52; i++) {
            rest |= spec[i] % 2 != 0;
            res += spec[i] - (spec[i] % 2 != 0 ? 1 : 0);
        }
        return res + (rest ? 1 : 0);
    }
}
