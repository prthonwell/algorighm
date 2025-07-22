package huweiB;

import java.util.*;

public class ode0043 {

    static class stu {
        String ClassNum;
        String ID;
        int Score;

        stu (String ClassNum, String ID, int Score) {
            this.ClassNum = ClassNum;
            this.ID = ID;
            this.Score = Score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(";");
        String[] s2 = sc.nextLine().split(";");
        HashMap<String, Integer> stus = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            String[] cur = s1[i].split(",");
            int num = Integer.parseInt(cur[1]);
            stus.put(cur[0], num);
        }
        List<stu> stuList = new ArrayList<>();
        for (int i = 0; i < s2.length; i++) {
            String[] cur = s2[i].split(",");
            if (stus.containsKey(cur[0])) {
                int num = Integer.parseInt(cur[1]);
                stuList.add(new stu(
                        cur[0].substring(0,5),
                        cur[0],
                        num + stus.get(cur[0])));
            }
        }
        if (stuList.isEmpty()) {
            System.out.println("NULL");
            return;
        }
        stuList.sort(new Comparator<stu>() {
            @Override
            public int compare(stu o1, stu o2) {
                return !o1.ClassNum.equals(o2.ClassNum) ? o1.ClassNum.compareTo(o2.ClassNum)
                        : o1.Score != o2.Score ? o2.Score - o1.Score
                        : o1.ID.compareTo(o2.ID);
            }
        });
        int index = 0;
        while (index < stuList.size()) {
            Queue<stu> q = new LinkedList<>();
            q.offer(stuList.get(index++));
            while (index < stuList.size()
                    && stuList.get(index).ClassNum.equals(stuList.get(index - 1).ClassNum)) {
                q.offer(stuList.get(index++));
            }
            System.out.println(q.peek().ClassNum);
            StringJoiner sj = new StringJoiner(";");
            while (!q.isEmpty()) {
                sj.add(q.poll().ID);
            }
            System.out.println(sj.toString());
        }
        sc.close();
    }
}
