package leetCode.from161to200;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0 || k % n == 0) return;
        int GYS = ZDGYS(Math.max(n, k), Math.min(n,k));
        int times = n / GYS;
        for (int i = 0; i < GYS; i++) {
            int index = i;
            int pre = nums[index];
            for (int j = 0; j < times; j++) {
                index = (index + k) % n;
                int cur = nums[index];
                nums[index] = pre;
                pre = cur;
            }
        }
    }

    private int ZDGYS(int max, int min) {
        if (max % min == 0) return min;
        return ZDGYS(min, max % min);
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
