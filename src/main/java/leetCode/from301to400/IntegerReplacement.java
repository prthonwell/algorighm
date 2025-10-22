package leetCode.from301to400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IntegerReplacement {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        IntegerReplacement i = new IntegerReplacement();
        System.out.println(i.integerReplacement(8));
    }
}
