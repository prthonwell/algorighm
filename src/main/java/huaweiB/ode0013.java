package huaweiB;

import java.util.*;

public class ode0013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        if (s.length > 999) {
            System.out.println("ERROR");
            return;
        }
        List<Integer> class1 = new ArrayList<>();
        List<Integer> class2 = new ArrayList<>();
        List<Integer> cur = class1;
        for (int i = 0; i < s.length; i++) {
            String[] ss = s[i].split("/");
            int id = Integer.parseInt(ss[0]);
            if (id <= 0 || id > 999) {
                System.out.println("ERROR");
                return;
            }
            if (ss[1].equals("N")) {
                if (cur == class2) {
                    cur = class1;
                } else {
                    cur = class2;
                }
            }
            cur.add(id);
        }
        sc.close();
        // 编号需按照大小升序排列
        class1.sort((a, b) -> a - b);
        String oneStr = getStr(class1);
        // 编号需按照大小升序排列
        class2.sort((a, b) -> a - b);
        String twoStr = getStr(class2);
        if (oneStr.isEmpty() && !twoStr.isEmpty()) {
            System.out.println(twoStr);
            System.out.println();
        } else if (twoStr.isEmpty() && !oneStr.isEmpty()) {
            System.out.println(oneStr);
            System.out.println();
        } else {
            if (oneStr.charAt(0) < twoStr.charAt(0)) {
                System.out.println(oneStr);
                System.out.println(twoStr);
            } else {
                System.out.println(twoStr);
                System.out.println(oneStr);
            }
        }
    }

    public static String getStr(List<Integer> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringJoiner sj = new StringJoiner(" ");
        for (Integer v : list) {
            sj.add(v + "");
        }
        return sj.toString();
    }

}
