package huweiB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ode0060 {
    static HashMap< String, Double> map = new HashMap<>();

    static {
        map.put("CNY", 100.00);
        map.put("HKD", 10000.00 / 123.00);
        map.put("JPY", 10000.00 / 1825.00);
        map.put("EUR", 10000.00 / 14.00);
        map.put("GBP", 10000.00 / 12.00);
        map.put("cents", (100.00 / 123.00));
        map.put("sen", (100.00 / 1825.00));
        map.put("eurocents", (100.00 / 14.00));
        map.put("pence", (100.00 / 12.00));
        map.put("fen", 1.00);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Double res = 0.00;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Pattern p = Pattern.compile("\\d+\\D+");
            Matcher m = p.matcher(line);
            while (m.find()) {
                String s = m.group();
                int index = 0;
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    index++;
                }
                int num = Integer.parseInt(s.substring(0, index));
                String str = s.substring(index);
                res += num * map.get(str);
            }
        }
        sc.close();
        StringBuilder stringBuilder = new StringBuilder();
        while (res >= 1) {
            stringBuilder.append((int)(res % 10));
            res /= 10;
        }
        System.out.println(stringBuilder.reverse().toString());
    }
}
