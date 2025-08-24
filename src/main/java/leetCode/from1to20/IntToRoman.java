package leetCode.from1to20;

public class IntToRoman {
    static class pair {
        char one;
        char five;
        char ten;
        pair(char one, char five, char ten) {
            this.one = one;
            this.five = five;
            this.ten = ten;
        }
    }
    static pair[] pairs = new pair[4];
    static {
        pairs[3] = new pair('M', ' ', ' ');
        pairs[2] = new pair('C', 'D', 'M');
        pairs[1] = new pair('X', 'L', 'C');
        pairs[0] = new pair('I', 'V', 'X');
    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int cur = num % 10;
            num /= 10;
            pair p = pairs[index++];
            StringBuilder sb = new StringBuilder();
            if (cur <= 3) {
                while (cur-- > 0) {
                    sb.append(p.one);
                }
            } else if (cur == 4) {
                sb.append(p.one).append(p.five);
            } else if (cur == 5) {
                sb.append(p.five);
            } else if (cur <= 8) {
                sb.append(p.five);
                cur -= 5;
                while (cur-- > 0) {
                    sb.append(p.one);
                }
            } else {
                sb.append(p.one).append(p.ten);
            }
            roman.insert(0, sb.toString());
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
    }
}
