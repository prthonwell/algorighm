package from121to140;

class IsPalindrome {
    // https://leetcode.cn/problems/valid-palindrome/
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length - 1, l = 0;
        while (l < n) {
            while (!((chars[l] <= 'z' && chars[l] >= 'a') || (chars[l] <= '9' && chars[l] >= '0') || (chars[l] <= 'Z' && chars[l] >= 'A'))) {
                if (l == n) break;
                l++;
            }
            while (!((chars[n] <= 'z' && chars[n] >= 'a') || (chars[n] <= '9' && chars[n] >= '0') || (chars[n] <= 'Z' && chars[n] >= 'A'))) {
                if (l == n) break;
                n--;
            }
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[n])) return false;
            l++;
            n--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab_a";
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println('_' > 'A' && '_' < 'z');
        System.out.println(isPalindrome.isPalindrome(s));
    }
}