package leetCode.from51to60;

import java.util.ArrayList;
import java.util.List;

class GetPermutation {
    // https://leetcode.cn/problems/permutation-sequence/ 60
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int cap = 1, mod = 2;
        while (mod < n) {
            cap *= mod++;
        }
        mod--;
        k--;
        StringBuilder sb = new StringBuilder();
        while (mod != 0) {
            int index = k / cap;
            sb.append(list.get(index));
            list.remove(index);
            k %= cap;
            cap /= mod--;
        }
        sb.append(list.get(0));
        return sb.toString();
    }
    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(4, 7));
    }
}