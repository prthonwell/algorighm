package NEWLeetCode.from1to10;

public class LengthOfLongestSubstring {
    //      给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    //      0 <= s.length <= 5 * 104
    //      s 由英文字母、数字、符号和空格组成
    public int lengthOfLongestSubstring(String s) {
        int len = 0, max = 0;
        int[] spec = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - ' ';
            if (spec[index] == 0) {
                spec[index] = 1;
                len++;
            } else {
                max = Math.max(max, len);
                int start = i - len, startIndex = 0;
                while ((startIndex = (s.charAt(start) - ' ')) != index) {
                    spec[startIndex] = 0;
                    start++;
                }
                len = i - start;
            }
        }
        max = Math.max(max, len);
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(" "));
    }
}
