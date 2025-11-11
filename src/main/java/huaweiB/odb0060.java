    package huaweiB;

import java.util.*;

public class odb0060 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (len == 0) {
                    len++;
                } else if (c >= s.charAt(i - 1)) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            } else {
                max = Math.max(max, len);
                len = 0;
            }
        }
        System.out.println(max);
    }

}
