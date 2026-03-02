package leetCode.from400to500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 10 || turnedOn == 9) return Collections.emptyList();
        int[] open = new int[10];
        List<int[]> combos = new ArrayList<>();
        dfs(combos, turnedOn, new int[10], 0);
        List<String> res = new ArrayList<>();
        for (int[] combo : combos) {
            int hour = combo[0] * 8 + combo[1] * 4 + combo[2] * 2 + combo[3];
            int minute = combo[4] * 32 + combo[5] * 16 + combo[6] * 8 + combo[7] * 4 + combo[8] * 2 + combo[9];
            if (hour >= 12 || minute >= 60) continue;
            if (minute < 10) {
                res.add(hour + ":0" + minute);
            } else {
                res.add(hour + ":" + minute);
            }
        }
        return res;
    }

    private void dfs(List<int[]> combos, int turnedOn, int[] arr, int index) {
        if (turnedOn == 0) {
            combos.add(arr.clone());
            return;
        }
        if (10 - index > turnedOn) {
            dfs(combos, turnedOn, arr, index + 1);
        }
        arr[index] = 1;
        dfs(combos, turnedOn - arr[index], arr, index + 1);
        arr[index] = 0;
    }

    public static void main(String[] args) {
        ReadBinaryWatch rb = new ReadBinaryWatch();
        System.out.println(rb.readBinaryWatch(1));
        System.out.println(rb.readBinaryWatch(2));
    }
}