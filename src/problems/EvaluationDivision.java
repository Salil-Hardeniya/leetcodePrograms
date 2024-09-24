package problems;

import java.util.*;

public class EvaluationDivision {
    public static void main(String[] args) {
        List<List<String>> eq = new ArrayList<>();
        eq.add(List.of("x1","x4"));
        eq.add(List.of("x2","x3"));
        eq.add(List.of("x1","x2"));
        eq.add(List.of("x2","x5"));
        double[] values = {3.0,0.5,3.4,5.6};
        List<List<String>> newQueries = new ArrayList<>();
        newQueries.add(List.of("x1","x5"));
        newQueries.add(List.of("x4","x5"));
        newQueries.add(List.of("x1","x3"));
        newQueries.add(List.of("x5","x5"));
        newQueries.add(List.of("x5","x1"));
        newQueries.add(List.of("x3","x4"));
        newQueries.add(List.of("x4","x3"));
        newQueries.add(List.of("x6","x6"));
        newQueries.add(List.of("x0","x0"));
        System.out.println(Arrays.toString(calcEquation(eq, values, newQueries)));

    }

        static Map<String, List<String>> adj = new HashMap<>();
        static Map<List<String>, Double> val = new HashMap<>();
        static Set<String> var = new HashSet<>();
        public static double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
            for(int i =0;i<values.length;i++){
                List<String> equation= eq.get(i);
                val.put(equation, values[i]);
                val.put(List.of(equation.get(1), equation.get(0)), 1/values[i]);
                var.add(equation.get(0));
                var.add(equation.get(1));
                adj.putIfAbsent(equation.get(0), new ArrayList<>());
                adj.putIfAbsent(equation.get(1), new ArrayList<>());
                adj.get(equation.get(0)).add(equation.get(1));
                adj.get(equation.get(1)).add(equation.get(0));
            }
            double[] res = new double[queries.size()];

            for(int i = 0;i<res.length;i++){
                if(!var.contains(queries.get(i).get(0)) || !var.contains(queries.get(i).get(1))){
                    res[i] = -1;
                }
                else
                    res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
            }
            return res;
        }

    private static double dfs(String s, String e, HashSet<String> visited) {
        if (s.equals(e))
            return 1;
        List<String> temp = List.of(s,e);
        if(val.containsKey(temp))
            return val.get(temp);

        visited.add(s);
        double ans = -1;
        for(String str : adj.get(s)){
            if (visited.contains(str)) continue;
            ans = Math.max(ans, dfs(str,e,visited));
            if(ans != -1){
                ans *= val.get(List.of(s,str));
                val.put(temp, ans);
                val.put(List.of(temp.get(1),temp.get(0)), 1/ans);
                break;
            }
        }
        return ans;
    }

}

