package mei;

import java.util.*;

public class cannon {
    public static void Cannon() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            LinkedHashMap<location, Integer> sq = new LinkedHashMap<>();
            LinkedHashMap<Integer, TreeMap<Integer, location>> X = new LinkedHashMap<>();
            LinkedHashMap<Integer, TreeMap<Integer, location>> Y = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                location cur = new location(x, y);
                sq.put(cur,0);
                if (X.containsKey(x)) {
                    X.get(x).put(y, cur);
                } else {
                    TreeMap<Integer, location> map = new TreeMap<>();
                    map.put(y, cur);
                    X.put(x, map);
                }
                if (Y.containsKey(y)) {
                    Y.get(y).put(x, cur);
                } else {
                    TreeMap<Integer, location> map = new TreeMap<>();
                    map.put(x, cur);
                    Y.put(y, map);
                }
            }
            X.forEach((k, v) -> {
                if (v.size() <= 2) return;
                else if (v.size() == 3) {
                    sq.put(v.firstEntry().getValue(), sq.get(v.firstEntry().getValue()) + 1);
                    sq.put(v.lastEntry().getValue(), sq.get(v.lastEntry().getValue()) + 1);
                } else if (v.size() == 4) {
                    for (Iterator<Map.Entry<Integer, location>> it = v.entrySet().iterator(); it.hasNext();) {
                        Map.Entry<Integer, location> entry = it.next();
                        sq.put(entry.getValue(), sq.get(entry.getValue()) + 1);
                    }
                } else {
                    int count = 0;
                    int size = v.size();
                    for (int i = 0; i < size - 2; i++) {
                        Map.Entry<Integer, location> Entry = v.firstEntry();
                        if (count < 2) {
                            sq.put(Entry.getValue(), sq.get(Entry.getValue()) + 1);
                            count++;
                        } else {
                            sq.put(Entry.getValue(), sq.get(Entry.getValue()) + 2);
                        }
                        v.remove(Entry.getKey());
                    }
                    while (count-- > 0) {
                        sq.put(v.firstEntry().getValue(), sq.get(v.firstEntry().getValue()) + 1);
                        v.remove(v.firstEntry().getKey());
                    }
                }
            });
            Y.forEach((k, v) -> {
                if (v.size() <= 2) return;
                else if (v.size() == 3) {
                    sq.put(v.firstEntry().getValue(), sq.get(v.firstEntry().getValue()) + 1);
                    sq.put(v.lastEntry().getValue(), sq.get(v.lastEntry().getValue()) + 1);
                } else if (v.size() == 4) {
                    for (Iterator<Map.Entry<Integer, location>> it = v.entrySet().iterator(); it.hasNext();) {
                        Map.Entry<Integer, location> entry = it.next();
                        sq.put(entry.getValue(), sq.get(entry.getValue()) + 1);
                    }
                } else {
                    int count = 0;
                    for (int i = 0; i < v.size() - 3; i++) {
                        Map.Entry<Integer, location> Entry = v.firstEntry();
                        if (count < 2) {
                            sq.put(Entry.getValue(), sq.get(Entry.getValue()) + 1);
                            count++;
                        } else {
                            sq.put(Entry.getValue(), sq.get(Entry.getValue()) + 2);
                        }
                    }
                    while (count-- > 0) {
                        sq.put(v.firstEntry().getValue(), sq.get(v.firstEntry().getValue()) + 1);
                    }
                }
            });
            sq.forEach((k, v) -> {
                System.out.println(v);
            });
        }
    }

    public static class location {
        int x;
        int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Cannon();
    }
}
