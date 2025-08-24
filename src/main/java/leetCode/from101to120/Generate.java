package leetCode.from101to120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int num = 2;
        int[] pre = new int [1];
        pre[0] = 1;
        res.add(Arrays.stream(pre).boxed().toList());
        while (num <= numRows) {
            int[] cur = new int[num];
            for (int i = 0; i < num; i++) {
                cur[i] = ((i != 0) ? pre[i - 1] : 0) + (i != num - 1 ? pre[i] : 0);
            }
            res.add(Arrays.stream(cur).boxed().toList());
            pre = cur;
            num++;
        }
        return res;
    }
    public static void main(String[] args) {
        Generate gen = new Generate();
        List<List<Integer>> res = gen.generate(3);
    }
}