package leetCode.from51to60;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, len = 0,res = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                if (len != 0) res = len;
                len = 0;
            } else {
                len++;
            }
        }
        if (len != 0) res = len;
        return res;
    }
}
