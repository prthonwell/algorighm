package structure;

public class SegmentTree {
    private final int[] tree;
    private final int size;
    private final int[] data;

    public SegmentTree(int[] arr) {
        size = arr.length;
        tree = new int[size << 2];
        data = arr.clone();
        buildTree(0, size - 1, 0);
    }

    // 构建树
    private void buildTree(int start, int end, int index) {
        if (start == end) {
            tree[index] = data[start];
            return;
        }

        int mid = start + (end - start) / 2;
        // 从0开始
        int leftChild = index << 1 + 1;
        int rightChild = leftChild + 1;

        buildTree(start, mid, leftChild);
        buildTree(mid + 1, end, rightChild);

        tree[index] = tree[leftChild] + tree[rightChild];
    }

    public int query(int l, int r) {
        return query(0, size - 1, l, r, 0);
    }

    // 查询区间最小值
    private int query(int start, int end, int l, int r, int index) {
        if (start > r || end < l) {
            return 0;
        }

        if (start > l && end <= r) {
            return tree[index];
        }

        int mid = start + (end - start) / 2;
        int leftChild = index << 1 + 1;
        int rightChild = leftChild + 1;

        int leftSum = query(start, mid, l, r, leftChild);
        int rightSum = query(mid + 1, end, l, r, rightChild);

        return leftSum + rightSum;
    }

    // 区域上加值
    public void update(int l, int r, int value) {
        update(0, size - 1, l, r, value, 0);
    }

    private void update(int start, int end, int l, int r, int value, int index) {
        if (start > r || end < l) {
            return;
        }

        if (start == end) {
            tree[index] += value;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = index << 1 + 1;
        int rightChild = leftChild + 1;

        update(start, mid, l, r, value, leftChild);
        update(mid + 1, end, l, r, value, rightChild);

        tree[index] = tree[leftChild] + tree[rightChild];
    }

}
