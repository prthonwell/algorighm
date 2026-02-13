package leetCode.from3601to3700;

class IsTrionic {
    public boolean isTrionic(int[] nums) {
        int n =  nums.length;
        int index = 0, p = 0, q = 0;
        while (index < n){
            int next = index + 1;
            if (next >= n || nums[next] == nums[index]) return false;
            if (nums[next] < nums[index]) {
                p = index;
                break;
            }
            index++;
        }
        if (p == 0) return false;
        while (index < n){
            int next = index + 1;
            if (next >= n || nums[next] == nums[index]) return false;
            if (nums[next] > nums[index]) {
                q = index;
                break;
            }
            index++;
        }
        if (p == q || q == n - 1) return false;
        while (index < n){
            int next = index + 1;
            if (next >= n) break;
            if (nums[next] <= nums[index]) return false;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsTrionic isTrionic = new IsTrionic();
        System.out.println(isTrionic.isTrionic(new int[]{1,2,1,0,1,0}));
    }
}