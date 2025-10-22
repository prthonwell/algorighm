package leetCode.from400to500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> spec = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            String a = equation.get(0);
            if (!spec.containsKey(a)) {
                spec.put(a, index++);
            }
            String b = equation.get(1);
            if (!spec.containsKey(b)) {
                spec.put(b, index++);
            }
        }
        int n = spec.size();
        double[][] map = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], Double.MIN_VALUE);
            map[i][i] = 1;
        }
        int m = equations.size();
        for (int i = 0; i < m; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map[spec.get(a)][spec.get(b)] = values[i];
            map[spec.get(b)][spec.get(a)] = 1 / values[i];
        }
        // floyd
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == i || k == i || k == j || map[j][k] != Double.MIN_VALUE) {
                        continue;
                    }
                    if (map[j][i] != Double.MIN_VALUE && map[i][k] != Double.MIN_VALUE) {
                        map[j][k] = map[i][k] * map[j][i];
                        map[k][j] = 1 / map[j][k];
                    }
                }
            }
        }
        int l = queries.size();
        double[] result = new double[l];
        for (int i = 0; i < l; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!spec.containsKey(a) || !spec.containsKey(b)) {
                result[i] = -1.00;
            } else {
                double v = map[spec.get(a)][spec.get(b)];
                result[i] = v == Double.MIN_VALUE ? -1.00 : v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "b")));
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("a", "d")));
        CalcEquation calcEquation = new CalcEquation();
        double[] result = calcEquation.calcEquation(equations, values, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
