package leetCode.from1to20;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap();
//        for(int i = 0; i < nums.length; i++){
//            if(!map.containsKey(target - nums[i])){
//                map.put(nums[i],i);
//            }else{
//                return new int[]{map.get(target - nums[i]),i};
//            }
//        }
//        return new int[]{-1,-1};
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int index1 = 0, index2 = n - 1;
        while (index1 < index2) {
            long sum = pairs[index1][0] + pairs[index2][0];
            if (sum == target) {
                return new int[] {pairs[index1][1], pairs[index2][1]};
            } else if (sum < target) {
                while (index1 < index2 && sum < target) {
                    index1++;
                    sum = pairs[index1][0] + pairs[index2][0];
                }
            } else {
                while (index1 < index2 && sum > target) {
                    index2--;
                    sum = pairs[index1][0] + pairs[index2][0];
                }
            }
        }
        return new int[0];
    }
}
