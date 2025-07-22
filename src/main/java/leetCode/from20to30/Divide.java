package leetCode.from20to30;

class Divide {
    // 29 模拟除法
    public static int divide(int dividend, int divisor) {
        // 最小值边界
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == divisor ? 1 : 0;
        }
        int a = dividend > 0 ? dividend : Neg(dividend);
        int fix = 0;
        if (dividend == Integer.MIN_VALUE) {
            a = Neg(dividend + 1);
            fix = 1;
        }
        int b = divisor > 0 ? divisor : Neg(divisor);
        int res = 0;
        for (int i = 30; i >= 0; i = BinaryMinus(i, 1)) {
            // 缩小分母而不是扩大分子
            int x = a >> i;
            if (x >= b) {
                res = BinaryAdd(res, 1<<i);
                a = BinaryMinus(a, b<<i);
                if (fix != 0) {
                    a = BinaryAdd(a, 1);
                    fix = 0;
                    i++;
                }
            }
        }
        return dividend>0 ^ divisor>0 ? Neg(res) : res;
    }
    public static int Neg(int a ) {
        return BinaryAdd(~a, 1);
    }
    public static int BinaryMinus(int a, int b) {
        if (b == 0) return a;
        int a1 = a ^ b, b1 = (b & a1)<<1;
        a = BinaryMinus(a1, b1);
        return a;
    }
    public static int BinaryAdd(int a, int b) {
        if (b == 0) return a;
        int a1 = a ^ b, b1 = (b & a)<<1;
        a = BinaryAdd(a1, b1);
        return a;
    }

    // 另一种方法
    public static int divide2(int dividend, int divisor) {
        int a = dividend > 0 ? dividend : Neg(dividend);
        int b = divisor > 0 ? divisor : Neg(divisor);
        int res = 0;
        int i =0;
        while (a >= b) {
            while (a >= b<<i) {
                i++;
            }
            i--;
            res |= (1<<i);
            a -= b<<i;
            i = 0;
        }
        return dividend>0 ^ divisor>0 ? Neg(res) : res;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
}