package leetCode.from161to200;

import java.util.HashMap;
import java.util.HashSet;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean negative = (numerator > 0 ^ denominator > 0) || (numerator < 0 ^ denominator < 0);
        long numerator1 = Math.abs((long)numerator);
        long denominator1 = Math.abs((long)denominator);
        HashMap<Long, Integer> used = new HashMap<>();
        long d = numerator1 / denominator1;
        numerator1 = (numerator1 - d * denominator1) * 10;
        if (numerator1 == 0) {
            return (negative ? "-" : "") + d;
        }
        StringBuilder afterDot = new StringBuilder();
        int index = 0;
        while (numerator1 != 0 && !used.containsKey(numerator1)) {
            used.put(numerator1, index++);
            long cur = numerator1 / denominator1;
            numerator1 = (numerator1 - cur * denominator1) * 10;
            afterDot.append(cur);
        }
        if (numerator1 == 0) {
            return (negative ? "-" : "") +  d + "." + afterDot;
        } else {
            afterDot.insert(used.get(numerator1), "(");
            return (negative ? "-" : "") +  d + "." + afterDot + ")";
        }
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(1, -2147483648));
    }
}
