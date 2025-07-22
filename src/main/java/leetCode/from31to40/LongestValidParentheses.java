package leetCode.from31to40;

class LongestValidParentheses {
    // https://leetcode.cn/problems/longest-valid-parentheses/
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len <= 1) return 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (left < right) {
                max = Math.max(max, left * 2);
                left = 0;
                right = 0;
            }
        }
        if (left == right) {
            max = Math.max(max, left * 2);
        } else {
            left = 0;
            right = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left > right) {
                    max = Math.max(max, right * 2);
                    left = 0;
                    right = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")(((((()())()()))()(()))(";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}