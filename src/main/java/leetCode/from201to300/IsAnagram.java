package leetCode.from201to300;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;
        int[] spec = new int[26];
        for (int i = 0; i < n; i++) {
            spec[s.charAt(i) - 'a']++;
            spec[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < n; i++) {
            if (spec[s.charAt(i) - 'a'] != 0) return false;
        }
        return true;
    }
}
