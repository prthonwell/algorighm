package huaweiA;

import java.util.*;

public class Ode0126 {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        sc.close();
        String[] equipments = line1.split(",");
        HashMap<String, Integer> mark = new HashMap<>();
        for (String equipment : equipments) {
            mark.put( equipment, 0);
        }
        HashMap<String, List<String>> graph = new HashMap<>();
        String[] relies = line2.split(",");
        for (int i = 0; i < relies.length; i++) {
            String[] cur = relies[i].split("<-");
            String child = cur[0];
            String father = cur[1];
            graph.computeIfAbsent( father, k -> new ArrayList<>() ).add( child );
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < equipments.length; i++) {
            String equipment = equipments[i];
            if (mark.get(equipment) == 0) {
                findCycle(graph, equipment, new ArrayList<>(), res, mark);
            }
        }
        System.out.println(res.size());
    }

    private static void findCycle(HashMap<String, List<String>> graph, String cur, List<String> path , Set<String> res, HashMap<String, Integer> mark) {
        if (mark.get(cur) == 1) {
            boolean started = false;
            for (String child : path) {
                if (started || child.equals(cur)) {
                    started = true;
                    res.add(child);
                }
            }
            return;
        }
        if (mark.get(cur) == 2) {
            return;
        }
        path.add(cur);
        mark.put(cur, 1);
        if (graph.containsKey(cur)) {
            for (String child : graph.get(cur)) {
                findCycle(graph, child, path , res, mark);
            }
        }
        path.remove(path.size() - 1);
        mark.put(cur, 2);
    }
}