package from51to60;

import java.util.ArrayList;
import java.util.List;

class GetPermutation {
    // https://leetcode.cn/problems/permutation-sequence/ 60
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 1;
        int level = 1;
        while (i < k) {
            i = i * ++level;
        }
        int minus = n - level;
        StringBuffer sb = new StringBuffer();
        for (int j = 1; j <= minus; j++) {
            sb.append(list.get(0));
            list.remove(0);
        }
        while (k > 0) {
            i = i / level--;
            int cur = (k - 1) / i;
            sb.append(list.get(cur));
            list.remove(cur);
            k = k % i;
        }
        while (list.size() > 0) {
            sb.append(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(5, 1));
    }
}