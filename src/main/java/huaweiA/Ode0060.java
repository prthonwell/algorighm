package huaweiA;

import java.util.*;

public class Ode0060 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = sc.nextInt();
        int worker = sc.nextInt();
        sc.close();
        String[] ss = s.split(" ");
        int n = ss.length;
        HashMap<Integer, List<Integer>> allTasks = new HashMap<>();
        for (int i = 0; i < n; i += 2) {
            int a = Integer.parseInt(ss[i]);
            int b = Integer.parseInt(ss[i + 1]);
            List<Integer> temp = allTasks.getOrDefault(a, new ArrayList<>());
            temp.add(b);
            allTasks.put(a, temp);
        }
        Queue<Integer> Tasks = new LinkedList<>();
        int[] workers = new int[worker];
        int time = 0;
        int lose = 0;
        while (!Tasks.isEmpty() || !allTasks.isEmpty()) {
            for (int i = 0; i < worker; i++) {
                if (workers[i] == 0 || workers[i] == 1) {
                    workers[i] = 0;
                    if (!Tasks.isEmpty()) {
                        workers[i] = Tasks.poll();
                    }
                } else {
                    workers[i]--;
                }
            }
            if (allTasks.containsKey(time)) {
                for (Integer task : allTasks.get(time)) {
                    boolean consumed = false;
                    if (Tasks.isEmpty()) {
                        for (int i = 0; i < worker; i++) {
                            if (workers[i] == 0) {
                                consumed = true;
                                workers[i] = task;
                                break;
                            }
                        }
                    }
                    if (!consumed) {
                        if (Tasks.size() < len) Tasks.add(task);
                        else {
                            lose++;
                            Tasks.add(task);
                            Tasks.poll();
                        }
                    }
                }
                allTasks.remove(time);
            }
            time++;
        }
        int rest = 0;
        for (int i = 0; i < worker; i++) {
            rest = Math.max(rest, workers[i]);
        }
        System.out.println((time + rest - 1) + " " + lose);
    }
}
