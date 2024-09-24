package problems;

import java.util.*;

public class CourseSchedule { //LC 207
    public static void main(String[] args) {
        int[][] pre = {{1,0}};
        System.out.println(canFinish(2,pre));
    }

    public static boolean canFinish(int num, int[][] pre) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] ints : pre) {
            adj.putIfAbsent(ints[1], new ArrayList<>());
            adj.get(ints[1]).add(ints[0]);
            map.put(ints[0], map.getOrDefault(ints[0], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i< num;i++){
            if(!map.containsKey(i)){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            Integer temp = q.poll();
            res.add(temp);
            if(adj.get(temp) == null)
                continue;
            for(Integer n : adj.get(temp)){
                map.computeIfPresent(n, (k,v) -> v - 1);
                if(map.get(n) == 0){
                    map.remove(n);
                    q.add(n);
                }
            }
        }

        return res.size() == num;
    }
}
