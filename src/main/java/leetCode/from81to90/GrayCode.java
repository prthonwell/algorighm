package leetCode.from81to90;

import java.util.ArrayList;
import java.util.List;

class GrayCode {
    // https://leetcode.cn/problems/gray-code/description/ 89
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int m = res.size();
            for (int j = m - 1; j >= 0; j--) {
                res.add(res.get(j) | 1 << (i - 1)); // 来回反复使用
            }
        }
        return res;
    }
}