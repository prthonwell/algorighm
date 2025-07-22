public class Convert {
    // https://fanyi.youdao.com/index.html#/TextTranslate
    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int separate = numRows * 2 - 2;
        int length = ((n-1) / separate) + 2;
        int[] top = new int[length];
        int index = 0;
        for (; index < length; index++) {
            top[index] = index * separate;
        }
        char[] res = new char[n];
        int resIndex = 0;
        for (index = 0; index < length; index++) {
            if (top[index] < n) res[resIndex++] = chars[top[index]];
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (index = 0; index < length; index++) {
                if (top[index] - i > 0 && top[index] - i < n) res[resIndex++] = chars[top[index] - i];
                if (top[index] + i < n) res[resIndex++] = chars[top[index] + i];
            }
        }
        for (index = 0; index < length; index++) {
            if (top[index] + numRows - 1 < n) res[resIndex++] = chars[top[index] + numRows - 1];
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
