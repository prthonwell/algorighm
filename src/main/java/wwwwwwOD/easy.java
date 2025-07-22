package wwwwwwOD;

import ob.ListNode;

import java.util.*;

public class easy {
    public int largestComponentSize(int[] nums) {
        HashMap<Integer, List<Integer>> NtoG = new HashMap<>();
        HashMap<Integer, List<Integer>> GtoN = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int g = 2; g * g <= nums[i]; g++) {
                if (nums[i] % g == 0) {
                    NtoG.putIfAbsent(nums[i], new ArrayList<>());
                    NtoG.get(nums[i]).add(g);
                    GtoN.putIfAbsent(g, new ArrayList<>());
                    GtoN.get(g).add(i);
                }
            }
            if (NtoG.containsKey(nums[i])) {
                int size = NtoG.get(nums[i]).size();
                for (int j = 0; j < size; j++) {
                    int g1 = NtoG.get(nums[i]).get(j);
                    int g = nums[i] / g1;
                    if (g == g1) continue;
                    NtoG.putIfAbsent(nums[i], new ArrayList<>());
                    NtoG.get(nums[i]).add(g);
                    GtoN.putIfAbsent(g, new ArrayList<>());
                    GtoN.get(g).add(i);
                }
            }
            NtoG.putIfAbsent(nums[i], new ArrayList<>());
            NtoG.get(nums[i]).add(nums[i]);
            GtoN.putIfAbsent(nums[i], new ArrayList<>());
            GtoN.get(nums[i]).add(i);
        }
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            res = Math.max(res, dfs(visited, i, nums, NtoG, GtoN));
        }
        return res;
    }

    private int dfs(boolean[] visited, int i, int[] nums, HashMap<Integer, List<Integer>> ntoG, HashMap<Integer, List<Integer>> gtoN) {
        visited[i] = true;
        int cur = 1;
        for (Integer g : ntoG.get(nums[i])) {
            for (Integer index : gtoN.get(g)) {
                if (visited[index]) continue;
                cur += dfs(visited, index, nums, ntoG, gtoN);
            }
        }
        return cur;
    }

    static int[][] offset = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        String start = "1.01";
        String end = "1.0001";
        String[] words = new String[] {"ab"};
        char[][] board = new char[][] {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        int[] nums1 = new int[] {4,6,15,35};
        int[] nums2 = new int[] {0,9,12,20};
        int[] nums3 = new int[] {5,18,22,30};
        int[][] matrix = new int[][] {
                {2,2},
                {73,660}
        };
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(5,18,22,30));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(4,10,15,24,26));
        easy e = new easy();
        e.largestComponentSize(nums1);
    }
}
