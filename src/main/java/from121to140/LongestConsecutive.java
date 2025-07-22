package from121to140;

import java.util.HashMap;

class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> used = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (used.containsKey(i)) {continue;}
            int count = 1;
            int left = 0, right = 0;
            if (used.containsKey(i + 1)) {
                right = used.get(i + 1);
            }
            if (used.containsKey(i - 1)) {
                left = used.get(i - 1);
            }
            count = left + right + 1;
            used.put(i - left, count);
            used.put(i,count);
            used.put(i + right, count);
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hn = new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(new LongestConsecutive().longestConsecutive(hn));
    }
}