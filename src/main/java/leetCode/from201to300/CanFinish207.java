package leetCode.from201to300;

import java.util.*;

public class CanFinish207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> finished = new HashSet<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }
        int count = 0;
        while (count < numCourses) {
            boolean find = false;
            for (int i = 0; i < numCourses; i++) {
                if (finished.contains(i)) continue;
                if (map.containsKey(i)) {
                    List<Integer> list = map.get(i);
                    for (int j = 0; j < list.size(); j++) {
                        if (finished.contains(list.get(j))) list.remove(j--);
                    }
                    if (!list.isEmpty()) continue;
                    else map.remove(i);
                }
                find = true;
                finished.add(i);
                count++;
            }
            if (!find) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        CanFinish207 c = new CanFinish207();
        System.out.println(c.canFinish(7, matrix));
    }
}
