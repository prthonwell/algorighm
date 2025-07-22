package leetCode.from61to70;

class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

}