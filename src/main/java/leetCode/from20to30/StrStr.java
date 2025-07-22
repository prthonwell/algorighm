package leetCode.from20to30;

import java.util.Arrays;

class StrStr {
    // 28 https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public static int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int[] rollBack = getRollBackIndex(chars2);
        int index = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (index == chars2.length) return i - index;
            if (chars1[i] == chars2[index]) {
                index++;
            } else {
                if (rollBack[index] == -1) {
                    index = 0;
                } else {
                    index = rollBack[index];
                    i--;
                }
            }
        }
        if (index == chars2.length) return chars1.length - index;
        return -1;
    }
    private static int[] getRollBackIndex(char[] chars) {
        int[] rollBack = new int[chars.length];
        rollBack[0] = -1;
        int index = 0;
        for (int i = 2; i < chars.length; i++) {
             if (chars[index] == chars[i - 1]) {
                 rollBack[i] = index + 1;
                 index++;
             }else {
                 if (rollBack[index] == -1) {
                     index = 0;
                 } else {
                     index = rollBack[index];
                     i--;
                 }
             }
        }
        return rollBack;
    }

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr(haystack, needle));
    }
}