package from91to100;

class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length(), val;
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = chars[n - 1] == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            int cur = chars[i] - '0';
            int next = chars[i + 1] - '0';
            val = cur * 10 + next;
            if (val <= 26 && 9 < val) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (val <= 9) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("12"));
    }
}