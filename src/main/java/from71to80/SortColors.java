package from71to80;

class SortColors {
    // https://leetcode.cn/problems/sort-colors/ 75
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }
        int start = 0;
        for (int i = 0; i < 3; i++) {
            int len = start + colors[i];
            for (int j = start; j < len; j++) {
                nums[j] = i;
            }
            start = len;
        }
    }
}