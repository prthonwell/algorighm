import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Reverse {
    // https://leetcode.cn/problems/reverse-integer/description/
    private int reverse(int x) {
        if (x <= 9 && x >= -9) return x;
        int res = 0;
        int rem = 0;
        while (x != 0) {
            rem = x % 10;
            x = x / 10;
            // 判断先乘后加越界与否的标准方式
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rem > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rem < Integer.MIN_VALUE % 10)) {
                return 0;
            } else {
                res = res * 10 + rem;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverse(1534236469));
    }
}
