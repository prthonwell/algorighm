package NEWLeetCode.from1to10;

public class LongestPalindrome {
    // 找出字符串中的最长回文字串
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n) {
                dp[i + 1][i] = true;
            }
         }
        int[] LongestRecord = new int[2];
        for (int len_m1 = 1; len_m1 < n; len_m1++) {
            for (int j = 0; j + len_m1 < n; j++) {
                if (s.charAt(j) == s.charAt(j + len_m1) && dp[j + 1][j + len_m1 - 1]) {
                    dp[j][j + len_m1] = true;
                    LongestRecord[0] = j;
                    LongestRecord[1] = j + len_m1;
                }
            }
        }
        return s.substring(LongestRecord[0], LongestRecord[1] + 1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome(s));
    }
}
