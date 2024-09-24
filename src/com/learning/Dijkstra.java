package com.learning;

import java.util.*;

public class Dijkstra {

    static int[] val;
    public static void main(String[] args) {

        Map<Integer, List<Pair>> adj = new HashMap<>();
        adj.put(0, List.of( new Pair(1, 10),  new Pair(2, 15)));
        adj.put(1, List.of( new Pair(3, 12),  new Pair(5, 15)));
        adj.put(2, List.of( new Pair(4, 10), new Pair(5, 5)));
        adj.put(3, List.of( new Pair(4, 2),  new Pair(5, 1)));
        adj.put(5, List.of( new Pair(4, 5)));
        val = new int[6];
        Arrays.fill(val, Integer.MAX_VALUE);
        dijkstra(adj,0);
        System.out.println(Arrays.toString(val));
    }

    private static void dijkstra(Map<Integer, List<Pair>> adj, Integer source) {
        val[source] = 0;
        Set<Integer> settledNodes = new HashSet<>();
        Comparator<Pair> comp = Comparator.comparingInt(p -> p.cost);
        PriorityQueue<Pair> pq = new PriorityQueue<>(comp);

        pq.offer(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            Integer node = pair.name;
            int cost = pair.cost;

            if (!adj.containsKey(node))
                continue;

            for(Pair p : adj.get(node)){
                if(settledNodes.contains(p.name))
                    continue;
                pq.offer(new Pair(p.name, cost + p.cost));
                val[p.name] = Math.min(val[p.name], cost + p.cost);
            }
            settledNodes.add(pair.name);
        }

    }

    public record Pair(Integer name, int cost) {
    }
}
