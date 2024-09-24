package problems;

import java.util.*;

public class MinimumHeightTree {
    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
    static int[][] adj;
    static int n;
    public static List<Integer> findMinHeightTreesTLE(int num, int[][] edges) { //solution1 TLE
        n = num;
        adj = new int[n][n];
        for(int[] edge : edges){
            adj[edge[0]][edge[1]] = adj[edge[1]][edge[0]] = 1;
        }

        Queue<Pair> q = new ArrayDeque<>();
        Pair p = new Pair(0, -1);
        q.offer(p);
        while(!q.isEmpty()){
            p = q.poll();
            for(int i = 0;i<n;i++){
                if(i != p.pre && adj[p.val][i] == 1){
                    q.offer(new Pair(i, p.val));
                }
            }
        }
        List<Integer> res = bfs(new Pair(p.val, -1));
        int l = res.size();
        List<Integer> ans = new ArrayList<>();
        if(l%2 == 0){
            ans.add(res.get(l/2));
            ans.add(res.get((l/2) - 1));
        }
        else {
            ans.add(res.get(l/2));
        }

        return ans;
    }

    static List<Integer> bfs(Pair p){
        List<Integer> ar = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i != p.pre && adj[p.val][i] == 1){
                List<Integer> a = bfs(new Pair(i, p.val));
                if(a.size() > ar.size())
                    ar = a;
            }
        }
        ar.add(p.val);
        return ar;
    }

    record Pair(int val, int pre){}



    public static List<Integer> findMinHeightTrees(int num, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();
        Set<Integer> ans = new HashSet<>();
        for(int i =0;i<num;i++){
            adj.add(new HashSet<>());
            ans.add(i);
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i =0;i<num;i++){
            if(adj.get(i).size() == 1)
                leaves.add(i);
        }
        while(num > 2){
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer n : leaves){
                Integer next = adj.get(n).iterator().next();
                ans.remove(n);
                adj.get(next).remove(n);
                if(adj.get(next).size() == 1){
                    newLeaves.add(next);
                }
                num--;
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(ans);
    }
}
