package from71to80;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class MinWindow {
    // https://leetcode.cn/problems/minimum-window-substring/ 76
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // 统计t中字符出现的频率
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0; // 滑动窗口的左右指针
        int minLeft = 0; // 最小窗口的左边界
        int minLen = Integer.MAX_VALUE; // 最小窗口长度
        int count = t.length(); // 需要匹配的字符总数

        while (right < s.length()) {
            // 扩展右边界
            char c = s.charAt(right);
            if (map[c] > 0) {
                count--; // 找到一个需要匹配的字符
            }
            map[c]--; // 减少该字符的计数（包括不需要匹配的字符）
            right++;

            // 当窗口包含所有t的字符时，尝试收缩左边界
            while (count == 0) {
                // 更新最小窗口
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }

                // 收缩左边界
                char leftChar = s.charAt(left);
                map[leftChar]++; // 恢复该字符的计数
                if (map[leftChar] > 0) {
                    count++; // 如果该字符是t中需要的，增加需要匹配的计数
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s = minWindow.minWindow("ADOBECODEBANC", "AABC");
    }
}