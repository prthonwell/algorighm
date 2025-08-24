package huaweiA;

import java.util.*;

public class Ode0084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(",");
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (String ss1 : ss) {
            if (ss1.equals("1")) {
                count++;
            } else {
                if (count != 0) {
                    list.add(count);
                    count = 0;
                }
            }
        }
        if (count != 0) {
            list.add(count);
            count = 0;
        }
        for (Integer integer : list) {
            count += integer / 3;
            if (integer % 3 != 0) {
                count++;
            }
        }
        sc.close();
        System.out.println(count);
    }
}
