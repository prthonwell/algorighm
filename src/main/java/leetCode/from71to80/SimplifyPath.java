package leetCode.from71to80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SimplifyPath {
    // https://leetcode.cn/problems/simplify-path/ 71
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<>();
        char[] chars = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        int countDot = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (i != 0 && chars[i - 1] == '/') {
                    continue;
                }
                if (countDot != 0) {
                    if (countDot > 2) {
                        char[] Dots = new char[countDot];
                        Arrays.fill(Dots, '.');
                        sb.append(Dots);
                    } else if (countDot == 2) {
                        if (!result.isEmpty()) result.remove(result.size() - 1);
                    }
                }
                countDot = 0;
                if (!sb.isEmpty()) result.add(sb.toString());
                sb = new StringBuilder();
            } else if (chars[i] == '.') {
                countDot++;
            } else {
                sb.append(chars[i]);
            }
        }
        if (countDot != 0) {
            if (countDot > 2) {
                char[] Dots = new char[countDot];
                Arrays.fill(Dots, '.');
                sb.append(Dots);
            } else if (countDot == 2) {
                if (!result.isEmpty()) result.remove(result.size() - 1);
            }
        }
        if (!sb.isEmpty()) result.add(sb.toString());
        String res = "";
        if (result.isEmpty()) {
            return "/";
        } else {
            for (String s : result) {
                if (s.equals(".")) continue;
                res = res + "/" + s;
            }
            return res;
        }
    }
}