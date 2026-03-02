package leetCode.from1601to1700;

class MinimumDeletions {
    public int minimumDeletions(String S) {
        char[] s = S.toCharArray();
        int del = 0;
        for (char c : s) {
            del += 'b' - c;  // count a
        }
        int res = del;
        for (char c : s) {
            del += (c - 'a') * 2 - 1; // a -> -1, b -> 1
            res = Math.min(res, del);
        }
        return res;
    }
}