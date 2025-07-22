public class FindMedianSortedArray2 {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // 第一个数组为短数组
        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = m + (n - m + 1) / 2;
        boolean isOdd = (m + n) % 2 == 1;

        int left = 0;
        int right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            // nums1中分割线的左边大于nums2中的分割线右边，说明区域划的太宽，分割线向左移动
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int right1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int right2 = j == n ? Integer.MAX_VALUE : nums2[j];
        int left1 = i - 1 < 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int left2 = j -1 < 0 ? Integer.MIN_VALUE : nums2[j - 1];
        return isOdd ? Math.max(left1, left2) : (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {-1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

