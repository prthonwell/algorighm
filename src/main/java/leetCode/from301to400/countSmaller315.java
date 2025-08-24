package leetCode.from301to400;

import java.util.*;

public class countSmaller315 {

    static class Tree {
        int[] counts;
        Tree (int len) {
            counts = new int[len << 2];
        }

        public void insert (int pos, int l, int r, int v) {
            if (l == r) {
                counts[pos]++;
                return;
            }
            int left = pos * 2;
            int right = left + 1;

            int midV = l + (r - l) / 2;
            if (v <= midV) {
                insert(left, l, midV, v);
            } else {
                insert(right, midV + 1, r, v);
            }
            counts[pos]++;
        }

        public int getLess (int pos, int l , int r, int v) {
            if (l == r) {
                return 0;
            }

            int left = pos * 2;
            int right = left + 1;

            int midV = l + (r - l) / 2;
            if (v <= midV) {
                return getLess(left, l, midV, v);
            } else {
                return counts[left] + getLess(right, midV + 1, r, v);
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        HashMap<Integer, Integer> getRank = new HashMap<>();
        HashMap<Integer, Integer> getNum = new HashMap<>();
        int[] dist = Arrays.stream(nums).distinct().sorted().toArray();
        int rank = 1;
        for (int i : dist) {
            getRank.put(i, rank);
            getNum.put(rank, i);
            rank++;
        }
        int n = dist.length;
        Tree tree = new Tree(n);
        int m = nums.length;
        int[] res = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            rank = getRank.get(nums[i]);
            res[i] = tree.getLess(1,1, n, rank);
            tree.insert (1, 1, n, rank);
        }
        return Arrays.stream(res).boxed().toList();
    }

    public static void main(String[] args) {
        countSmaller315 test = new countSmaller315();
        int[] nums = new int[] {5,2,6,1,0, -1, 3, 2};
        System.out.println(test.countSmaller(nums));
    }
}
