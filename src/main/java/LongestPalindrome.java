public class LongestPalindrome {
    // https://leetcode.cn/problems/longest-palindromic-substring/description/
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int [n][n];
        // 长度为一的子串都是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int right = 0;
        int reLength = 1;
        int startPoint = 0;
        // 从长度为2的子串开始
        for (int length = 2; length <= n; length++) {
            for (int i = 0; (right = i + length - 1) < n; i++) {
                if (chars[i] == chars[right] && (dp[i + 1][right - 1] == 1 || i + 1 >= right - 1)) {
                    dp[i][right] = 1;
                    if (right - i + 1 > reLength) {
                        reLength = right - i + 1;
                        startPoint = i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startPoint; i < startPoint + reLength; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
