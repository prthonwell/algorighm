package leetCode.from61to70;

class MySqrt {
    // https://leetcode.cn/problems/sqrtx/ 69
    public int mySqrt(int x) {
        int start = 0;
        int i = 1;
        while (true) {
            if ((long)(start+ i) * (start+ i) > x) {
                if (i == 1 || i == 2) {
                    return start + i - 1;
                }
                start = start + (i >> 1);
                i = 1;
                continue;
            }
            i = i << 1;
        }
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(36));
    }
}