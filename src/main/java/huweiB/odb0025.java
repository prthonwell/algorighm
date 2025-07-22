package huweiB;

import java.util.*;

public class odb0025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] versions = sc.nextLine().split(",");
        String[] ver1 = versions[0].split("\\.");
        String[] ver2 = versions[1].split("\\.");
        sc.close();
        int len = Math.min(ver1.length, ver2.length);
        int res = 0, index = 0;
        for (; index < len; index++) {
            int a = Integer.parseInt(ver1[index]);
            int b = Integer.parseInt(ver2[index]);
            if (a == b) continue;
            if (a > b) {
                System.out.println(0);
                return;
            }
            res = b - a - 1;
            break;
        }
        index++;
        while (index < ver2.length) {
            if (Integer.parseInt(ver2[index]) != 0) {
                res = 0;
                break;
            }
            index++;
        }
        System.out.println(res);
    }
}
