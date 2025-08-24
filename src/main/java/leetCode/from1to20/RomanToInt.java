package leetCode.from1to20;

import java.util.HashMap;

public class RomanToInt {
    static class Pair {
        int val;
        char five;
        char ten;
        Pair(int val, char five, char ten) {
            this.val = val;
            this.five = five;
            this.ten = ten;
        }
    }
    static HashMap<Character, Pair> map = new HashMap<Character, Pair>();
    static {
        Pair I = new Pair(1, 'V', 'X');
        Pair X = new Pair(10, 'L', 'C');
        Pair C = new Pair(100, 'D', 'M');
        map.put('I', I);
        map.put('X', X);
        map.put('C', C);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0, n = chars.length;
        for (int i = 0; i < chars.length; i++) {
            int cur;
            char c = chars[i];
            int index = i + 1;
            if (c == 'I' || c == 'X' || c == 'C') {
                Pair pair = map.get(c);
                cur = pair.val;
                if (index < n) {
                    if (chars[index] == pair.five) {
                        cur = cur * 4;
                    } else if (chars[index] == pair.ten) {
                        cur = cur * 9;
                    } else {
                        while (index < n && chars[index] == c) {
                            cur += pair.val;
                            index++;
                        }
                        index--;
                    }
                }
                i = index;
            } else if (c == 'V') {
                cur = 5;
                while (index < n && chars[index] == 'I') {
                    cur++;
                    index++;
                }
                index--;
                i = index;
            } else if (c == 'L') {
                cur = 50;
                while (index < n && chars[index] == 'X') {
                    cur+=10;
                    index++;
                }
                index--;
                i = index;
            } else if (c == 'D') {
                cur = 500;
                while (index < n && chars[index] == 'C') {
                    cur+= 100;
                    index++;
                }
                index--;
                i = index;
            } else {
                cur = 1000;
            }
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInt r = new RomanToInt();
        System.out.println(r.romanToInt("MCMXCIV"));
    }
}
