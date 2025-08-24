package leetCode.from301to400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
