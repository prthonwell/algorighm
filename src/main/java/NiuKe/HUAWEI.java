package NiuKe;

import java.util.ArrayList;

public class HUAWEI {
    public static int Kill3 (int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int index = 2;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int left = n;
        while (left != 1) {
            arr.remove(index);
            index--;
            left--;
            index += 3;
            index = index % left;
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        System.out.println(Kill3(9));
    }
}
