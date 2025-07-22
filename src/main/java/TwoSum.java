import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[][] numsCopy = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = new int[] {nums[i], i};
        }
        Arrays.sort(numsCopy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] result = new int[2];
        for (int i = 0; i < numsCopy.length; i++) {
            result[0] = numsCopy[i][1];
            int rest = target - numsCopy[i][0];
            if (rest < 0) continue;
            int parttern = binarySearch(numsCopy, rest, 0, numsCopy.length - 1);
            if (parttern == -1) continue;
            else if (i != parttern) {
                result[1] = numsCopy[parttern][1];
                return result;
            }
            else if (numsCopy[i][0] == numsCopy[parttern + 1][0]) {
                result[1] = numsCopy[parttern + 1][1];
                return result;
            }
            else if (numsCopy[i][0] == numsCopy[parttern - 1][0]) {
                result[1] = numsCopy[parttern - 1][1];
                return result;
            }
        }
        return result;
    }
    public static int binarySearch(int[][] nums, int rest, int left, int right) {
        if (left == right) return nums[right][0] == rest ? right : -1;
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid][0] == rest) return mid;
        else if (nums[mid][0] > rest) return binarySearch(nums, rest, left, mid - 1);
        else return binarySearch(nums, rest, mid + 1, right);
    }


    public static void main(String[] args) {
        Double round = 1.0;
        System.out.println((int)Math.pow(10.0, ++round));
        int[] nums = {3,2,4};
        int target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

}
