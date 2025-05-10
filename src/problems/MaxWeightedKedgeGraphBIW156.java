package problems;

import java.util.*;

public class MaxWeightedKedgeGraphBIW156 {
    public static void main(String[] args) {
        MaxWeightedKedgeGraphBIW156 maxWeightedKedgeGraphBIW156 = new MaxWeightedKedgeGraphBIW156();
        int[][] edge = {};
        int ans = maxWeightedKedgeGraphBIW156.maxWeight(1,edge,0,287);
        System.out.println(ans);
    }
    // TLE
//    HashMap<Integer, List<Pair>> map = new HashMap<>();
//    public int maxWeight(int n, int[][] edges, int k, int t) {
//        for(int[] ar : edges){
//            map.putIfAbsent(ar[0], new ArrayList<>());
//            map.get(ar[0]).add(new Pair(ar[1], ar[2]));
//        }
//        int ans = -1;
//        for(int i = 0;i<n;i++){
//            ans = Math.max(ans, dfs(i, k, t));
//        }
//
//        return ans;
//    }
//
//    public int dfs(int src, int k, int t){
//        Deque<PathNode> deque = new ArrayDeque<>();
//        int sum = -1;
//        deque.add(new PathNode(src, 0, 0));
//        while(!deque.isEmpty()){
//            PathNode node = deque.pop();
//            int v = node.node;
//            int s = node.sum;
//            if (node.edge == k) {
//                if (node.sum < t) {
//                    sum = Math.max(sum, node.sum);
//                }
//                continue; // don't go deeper
//            }
//            List<Pair> list = map.getOrDefault(v, new ArrayList<>());
//            for(Pair p : list){
//                deque.push(new PathNode(p.node, s + p.wt, node.edge + 1));
//            }
//        }
//        return sum;
//    }
//
//    private static class PathNode {
//        int node;
//        int sum;
//        int edge;
//
//        PathNode(int node, int sum, int edge) {
//            this.node = node;
//            this.sum = sum;
//            this.edge = edge;
//        }
//    }

    HashMap<Integer, List<Pair>> map = new HashMap<>();
    Map<String, Integer> memo = new HashMap<>();
    public int maxWeight(int n, int[][] edges, int k, int t) {
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            int result = dfs(i, k, 0, t);
            if (result != -1) {
                ans = Math.max(ans, result);
            }
        }
        return ans;
    }

    private int dfs(int node, int edgesLeft, int currentSum, int t) {
        if (currentSum >= t) return -1;
        if (edgesLeft == 0) return currentSum;

        String key = node + "_" + edgesLeft + "_" + currentSum;
        if (memo.containsKey(key)) return memo.get(key);

        int maxSum = -1;
        for (Pair neighbor : map.getOrDefault(node, new ArrayList<>())) {
            int newSum = currentSum + neighbor.wt;
            int result = dfs(neighbor.node, edgesLeft - 1, newSum, t);
            if (result != -1) {
                maxSum = Math.max(maxSum, result);
            }
        }

        memo.put(key, maxSum);
        return maxSum;
    }

    public static class Pair {
        int node; int wt;
        Pair(int x, int y){
            this.node = x;
            this.wt = y;
        }
    }



}
