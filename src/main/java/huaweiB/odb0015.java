package huaweiB;

import java.util.*;

public class odb0015 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        // 第一个
        int[] framework = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            framework[i] = line[0].charAt(i + 1) - line[0].charAt(i);
        }
        // 第二个
        boolean same = true;
        for (int i = 0; i < n - 1; i++) {
            if (framework[i] != line[1].charAt(i + 1) - line[1].charAt(i)) {
                same = false;
                break;
            }
        }
        if (same) {
            for (int j = 2; j < m; j++) {
                String str = line[j];
                boolean flag = true;
                for (int i = 0; i < n - 1; i++) {
                    if (framework[i] != str.charAt(i + 1) - str.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(str);
                    return;
                }
            }
        } else {
            // 第三个
            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if (framework[i] != line[2].charAt(i + 1) - line[2].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println(line[0]);
            } else {
                System.out.println(line[1]);
            }
        }
    }
}
