package from31to40;

class NextPermutation {

    // https://leetcode.cn/problems/next-permutation/ 31
    public void nextPermutation(int[] nums) {
        int tail = nums.length - 1;
        int head = tail - 1;
        while (head >= 0 && nums[head] >= nums[tail]) {
            head--;
            tail--;
        }
        if (head < 0) {
            // 翻转
            for (int i = 0; i < nums.length / 2; i ++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            // 找到比nums[head]大的最小值
            for (int i = nums.length - 1; i > head; i--) {
                if (nums[i] > nums[head]) {
                    tail = i;
                    break;
                }
            }
            // 交换位置
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            // 翻转
            for (int i = head + 1, j = nums.length - 1; i < j; i++, j--) {
                int temp2 = nums[i];
                nums[i] = nums[j];
                nums[j] = temp2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new NextPermutation().nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}