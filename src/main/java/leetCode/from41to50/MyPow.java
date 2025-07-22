package leetCode.from41to50;

class MyPow {
    // https://leetcode.cn/problems/powx-n/ 50
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0 || x == 1) return 1;
        if (n < 0) {
            return 1/process(x, Math.abs((long)n));
        }
        return process(x, n);
    }
    private double process(double x, long n) {
        if (n == 1) return x;
        long mid = n >> 1;
        double res = process(x, mid);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}