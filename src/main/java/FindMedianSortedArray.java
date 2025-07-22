public class FindMedianSortedArray {
    // https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int mid = (l1 + l2 - 1) / 2;
        int rest = (l1 + l2) % 2;
        if (l1 == 0) return rest == 1 ? nums2[mid] : (nums2[mid] + nums2[mid + 1]) / 2.0;
        if (l2 == 0) return rest == 1 ? nums1[mid] : (nums1[mid] + nums1[mid + 1]) / 2.0;
        if (l1 == l2) return process(nums1, nums2, false);
        int[] LongNums = l1 > l2 ? nums1 : nums2;
        int[] fixedNums = l1 > l2 ? nums2 : nums1;
        int longer = LongNums.length;
        int shorter = fixedNums.length;
        int start = 0;
        while (longer - start > shorter) {
            if (fixedNums[0] >= LongNums[longer - 1]) {
                return rest == 1 ? LongNums[mid] : (LongNums[mid] + LongNums[mid + 1]) / 2.0;
            }
            if (fixedNums[shorter - 1] <= LongNums[start]) {
                return rest == 1 ? LongNums[mid - shorter] : (LongNums[mid - shorter] + LongNums[mid - shorter + 1]) / 2.0;
            }
            start++;
            if (longer - start > shorter) longer--;
        }
        int[] fixedLongNums = new int[shorter];
        int ind = 0;
        for (int i = start; i < longer; i++) {
            fixedLongNums[ind++] = LongNums[i];
        }
        return process(fixedLongNums, fixedNums, rest == 1);
    }


    public static double process(int[] nums1, int[] nums2, boolean IsOdd) {
        int n = nums1.length;
        if (n == 1) return IsOdd ? Math.min(nums1[0], nums2[0]) : (nums2[0] + nums1[0] == 0 ? 0 : (nums2[0] + nums1[0]) / 2.0);
        int mid = (n - 1) / 2;
        int[] newNums1 = new int[mid + 1];
        int[] newNums2 = new int[mid + 1];
        int i1 = 0;
        int i2 = n / 2;
        if (nums1[mid] > nums2[mid]) {
            for (int i = 0; i < mid + 1; i++) {
                newNums1[i] = nums1[i1++];
                newNums2[i] = nums2[i2++];
            }
            return process(newNums1, newNums2, IsOdd);
        } else {
            for (int i = 0; i < mid + 1; i++) {
                newNums1[i] = nums2[i1++];
                newNums2[i] = nums1[i2++];
            }
            return process(newNums1, newNums2, IsOdd);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2,4};
        int[] nums2 = new int[] {1,3,4,5,6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
