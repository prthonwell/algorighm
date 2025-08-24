package leetCode.from1to20;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public String convert(String s, int numRows) {
        int sp = numRows * 2 - 2;
        char[] chars = s.toCharArray();
        int index = 0, n = chars.length;
        List<Integer> top = new ArrayList<>();
        while (index < n) {
            top.add(index);
            index += sp;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : top) {
            sb.append(chars[i]);
        }
        int offset = 1;
        while (offset < numRows - 1) {
            for (int i = 0; i < top.size(); i++) {
                int n1 = top.get(i) + offset;
                int n2 = top.get(i) + sp - offset;
                if (n1 < n) sb.append(chars[n1]);
                if (n2 < n) sb.append(chars[n2]);
            }
            offset += 1;
        }
        for (int i = 0; i < top.size(); i++) {
            int bottom = top.get(i) + offset;
            if (bottom < n) sb.append(chars[bottom]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String s = convert.convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
