package huweiB;

import java.util.*;

public class odb0033 {

    static String[] danWei1 = {"拾", "佰", "仟"};
    static String[] danWei2 = {"元", "万", "亿", "万亿", "亿亿"};
    static String[] nums = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split("\\.");
        int n = ss[0].length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            int dis = (n - i) / 4;
            int limit = i - 4;
            boolean added = false;
            StringBuilder cur = new StringBuilder();
            while (i > limit && i >= 0) {
                char c = ss[0].charAt(i);
                if (c == '0') {
                    if (added && cur.charAt(cur.length() - 1) != '零') cur.append(nums[0]);
                } else {
                    if (!added) {
                        cur.append(danWei2[dis]);
                        added = true;
                    }
                    int a = 4 - (i - limit) - 1;
                    if (a >= 0) {
                        cur.append(danWei1[a]);
                    }
                    cur.append(nums[c - '0']);
                }
                i--;
            }
            i++;
            stringBuilder.append(cur);
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.reverse();
            String m = "零壹拾";
            if (stringBuilder.charAt(0) == m.charAt(1) && stringBuilder.charAt(1) == m.charAt(2)) {
                stringBuilder.deleteCharAt(0);
            }
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == m.charAt(0)
                        && stringBuilder.charAt(i + 1) == m.charAt(1)
                        && stringBuilder.charAt(i + 2) == m.charAt(2)) {
                    stringBuilder.delete(i, i + 3);
                    stringBuilder.insert(i, "零拾");
                }
            }
        }
        if (ss[1].equals("00")) {
            System.out.println("人民币" + stringBuilder.toString() + "整");
            return;
        }
        int a = ss[1].charAt(0) - '0';
        int b = ss[1].charAt(1) - '0';
        if (a > 0) stringBuilder.append(nums[a]).append("角");
        if (b > 0) stringBuilder.append(nums[b]).append("分");
        System.out.println("人民币" + stringBuilder.toString());
    }
}
