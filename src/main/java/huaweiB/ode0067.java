package huaweiB;

import java.util.*;

public class ode0067 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        int cur = 1, pre = 0;
        while (cur < 1000000000) {
            map.put( cur, pre );
            pre = cur + pre * 9;
            cur *= 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int mod = 100000000;
        int minus = 0, origin = num;
        while (mod > 0) {
            int cur = num / mod;
            if (cur > 0) {
                num %= mod;
                int index = 0;
                while (index < cur) {
                    if (index == 4) {
                        minus += mod;
                    } else {
                        minus += map.get( mod );
                    }
                    index++;
                }
            }
            mod /= 10;
        }
        System.out.println(origin - minus);
    }
}
