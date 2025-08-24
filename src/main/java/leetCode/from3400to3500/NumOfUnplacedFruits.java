package leetCode.from3400to3500;

import java.util.HashSet;

public class NumOfUnplacedFruits {

    class tree {
        int[] max;
        int start = 1;
        tree(int[] arr) {
            int len = 1;
            while (len < arr.length) {
                len <<= 1;
            }
            max = new int[len << 1];
            fill(max, arr, start, 0, len);
        }

        void fill(int[] max, int[] arr, int pos, int index, int len) {
            if (len == 1) {
                if (index >= arr.length) max[pos] = 0;
                else max[pos] = arr[index];
                return;
            }
            int left = pos * 2;
            int right = left + 1;
            int half = len >> 1;
            fill(max, arr, left, index, half);
            fill(max, arr, right, index + half, half);
            max[pos] = Math.max(max[left], max[right]);
        }

        boolean findAndUse (int val) {
            return FAU(val, start);
        }

        boolean FAU(int val, int pos) {
            if (val > max[pos]) return false;
            int left = pos * 2;
            if (left >= max.length) {
                max[pos] = 0;
                return true;
            }
            int right = left + 1;
            boolean res;
            if (val <= max[left]) {
                res = FAU(val, left);
            } else {
                res = FAU(val, right);
            }
            max[pos] = Math.max(max[left], max[right]);
            return res;
        }

    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        if (fruits.length == 0 || baskets.length == 0) return 0;
        if (fruits.length == 1 || baskets.length == 1) return baskets[0] > fruits[0] ? 0 : 1;
        tree tree = new tree(baskets);
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (!tree.findAndUse(fruits[i])) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] fruits = new int[] {3,6,1}, baskets = new int[] {6,4,7};
        NumOfUnplacedFruits nuf = new NumOfUnplacedFruits();
        System.out.println(nuf.numOfUnplacedFruits(fruits, baskets));
    }
}
