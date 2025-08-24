package leetCode.from2000to2100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxTaskAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0;
        int r = Math.min(tasks.length, workers.length);
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int workerIndex = workers.length - 1;
        int pillIndex = k - 1;
        int count = 0;
        while (pillIndex >= 0) {
            int cur = tasks[pillIndex--];
            while (workerIndex >= workers.length - k && workers[workerIndex] + strength >= cur) {
                stack.addFirst(workers[workerIndex]);
                workerIndex--;
            }

            if (!stack.isEmpty() && stack.peekLast() >= cur) {
                stack.removeLast();
            } else {
                if (stack.isEmpty()) return false;
                if (count >= pills) return false;
                count++;
                stack.removeFirst();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaxTaskAssign maxTaskAssign = new MaxTaskAssign();
        int i = maxTaskAssign.maxTaskAssign(new int[]{3, 2, 1}, new int[]{0, 3, 3}, 1, 1);
        System.out.println(i);
    }
}
