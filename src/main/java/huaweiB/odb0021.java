package huaweiB;

import java.util.*;

public class odb0021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(",");
        int max = 0, count = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("0")) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = (max + 1) / 2;
        if (count != 0) {
            max = Math.max(max, count);
        }
        if (ss[0].equals("0")) {
            count = 1;
            int index = 1;
            while (ss[index].equals("0")) {
                index++;
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
