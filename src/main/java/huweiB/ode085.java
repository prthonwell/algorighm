package huweiB;

import java.util.*;

public class ode085 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream( sc.nextLine().split(",")).mapToInt( Integer::parseInt ).toArray();
        int n = arr.length;
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        list.sort( (a, b) -> b - a);
        int ListIndex = 0, arrIndex = 0;
        boolean[] marked = new boolean[n];
        while (ListIndex < list.size()) {
            if (marked[arrIndex]) {
                arrIndex = (arrIndex + 1) % n;
                continue;
            }
            if (arr[arrIndex] == list.get(ListIndex)) {
                arr[arrIndex] = ListIndex;
                marked[arrIndex] = true;
                ListIndex++;
            }
            arrIndex = (arrIndex + 1) % n;
        }
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < n; i++) {
            sj.add(arr[i] + "");
        }
        System.out.println(sj.toString());
        sc.close();
    }
}
