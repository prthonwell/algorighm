package leetCode.from31to40;

class CountAndSay {
    // https://leetcode.cn/problems/count-and-say/ 38
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        int count = 1;
        char[] chars = s.toCharArray();
        char cur = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                sb.append(count).append(cur);
                count = 1;
                cur = chars[i];
            }
        }
        return sb.append(count).append(cur).toString();
    }
}