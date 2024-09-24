package problems;

import java.util.*;

public class AllAncestorsAcyclicDirected2192 {
    public static void main(String[] args) {
        int[][] array = {
                {0,3},
                {0,4},
                {1,3},
                {2,4},
                {2,7},
                {3,5},
                {3,6},
                {3,7},
                {4,6}
        };
        System.out.println(getAncestors(8, array));
    }

    static List<Set<Integer>> list = new ArrayList<>();
    static List<List<Integer>> adj = new ArrayList<>();
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        long st = System.nanoTime();
        for(int i = 0;i<n;i++){
            list.add(new HashSet<>());
            adj.add(new ArrayList<>());
        }
        Set<Integer> arr = new HashSet<>();
        for(int[] ar : edges){
            arr.add(ar[0]);
            adj.get(ar[0]).add(ar[1]);
        }
        for(int[] ar : edges){
            arr.remove(ar[1]);
        }
        long ed = System.nanoTime();
        System.out.println("Time initialize: "+(ed-st));
        st = System.nanoTime();
        for (Integer integer : arr) {
            dfs(integer, new ArrayList<>());
        }
        ed = System.nanoTime();
        System.out.println("Time dfs: "+(ed-st));
        List<List<Integer>> res = new ArrayList<>();
        st = System.nanoTime();
        for(Set<Integer> set : list){
            List<Integer> l = new ArrayList<>(set);
            Collections.sort(l);
            res.add(l);
        }
        ed = System.nanoTime();
        System.out.println("Time getting res: "+(ed-st));
        return res;
    }


    static void dfs(Integer num, List<Integer> anc){
        list.get(num).addAll(anc);

        anc.add(num);
        for(Integer n : adj.get(num)){
            dfs(n,new ArrayList<>(anc));
        }
    }
    //TODO approach 2 - Topological sort with dfs
}
