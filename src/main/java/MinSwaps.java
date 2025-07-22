public class MinSwaps {
    // https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/submissions/611672774/?envType=daily-question&envId=2025-03-17
    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int n = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == ']') {
                n++;
            } else {
                max = Math.max(max, n);
                n--;
            }
        }
        max = Math.max(max, n);
        return max / 2 + max % 2;
    }

    public static void main(String[] args) {
        String s = "[[][][]]][";
        System.out.println(minSwaps(s));
    }


}
