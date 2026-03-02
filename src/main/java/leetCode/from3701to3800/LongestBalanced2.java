package leetCode.from3701to3800;

import java.util.Arrays;
import java.util.HashMap;

class LongestBalanced2 {

    static class SegmentTree {
        static final class Node {
            int max;
            int min;
            int todo;

            Node () {
                max = 0;
                min = 0;
                todo = 0;
            }
        }

        int n;
        Node[] nodes;
        public SegmentTree(int n) {
            this.n = n;
            nodes = new Node[2 << (32 -  Integer.numberOfLeadingZeros(n - 1))];
            Arrays.setAll(nodes, a -> new Node());
        }

        public void update(int l, int r, int val) {
            update(0,0, n - 1, l, r, val);
        }

        private void update(int idx, int l, int r, int ll, int rr, int val) {
            if (ll > r || rr < l) return;

            spread(idx);

            if (ll <= l && rr >= r) {
                apply(idx, val);
                return;
            }
            int mid = l +  (r - l) / 2;
            int left = idx * 2;
            int right = idx * 2 + 1;

            update(left, l, mid, ll, rr, val);
            update(right, mid + 1, r, ll, rr, val);

            nodes[idx].max = Math.max(nodes[left].max, nodes[right].max);
            nodes[idx].min = Math.min(nodes[left].min, nodes[right].min);

        }

        private void spread(int idx) {
            Node node = nodes[idx];
            int todo = node.todo;
            if (todo == 0) {
                return;
            }
            apply(idx * 2, todo);
            apply(idx * 2 + 1, todo);
            node.todo = 0;
        }

        private void apply(int i, int todo) {
            Node node = nodes[i];
            node.max += todo;
            node.min += todo;
            node.todo += todo;
        }

        public int findFirst(int ll, int rr, int val) {
            return findFirst(0, 0, n - 1, ll, rr, val);
        }

        private int findFirst(int idx, int l, int r, int ll, int rr, int val) {
            if (ll > rr || rr < l || nodes[idx].max < val || nodes[idx].min > val) return -1;
            if (l == r) {
                return l;
            }
            int mid = l + (r - l) / 2;
            int left = idx * 2;
            int right = idx * 2 + 1;

            int res = findFirst(left, l, mid, ll, rr, val);
            if (res == -1) {
                res = findFirst(right, mid + 1, r, ll, rr, val);
            }
            return res;
        }


    }


    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int res = 0, curDiff = 0; // odd - even
        SegmentTree segmentTree = new SegmentTree(n);
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int del = nums[i] % 2 == 0 ? -1 : 1;
            curDiff += del;
            Integer last = lastIdx.get(nums[i]);
            if (last == null) {
                segmentTree.update(i, n - 1, del);
            } else {
                segmentTree.update(last, i - 1, -del);
            }
            lastIdx.put(nums[i], i);

            int head = segmentTree.findFirst(0, i - res, curDiff);
            if (head != -1) {
                res = i - head;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,5,2, 3};
        System.out.println(new LongestBalanced2().longestBalanced(arr));
    }

}