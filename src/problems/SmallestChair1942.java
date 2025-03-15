package problems;

import java.util.*;

public class SmallestChair1942 {
    public static void main(String[] args) {
        SmallestChair1942 smallestChair1942 = new SmallestChair1942();
        int ans = smallestChair1942.smallestChair(new int[][]{{33,35},{26,29},{9,28},{4,31},{8,10},{32,34},{15,24},{27,39},{14,36},{1,14},{25,39},{5,27},{6,15},{2,38},{19,36},{24,34},{3,26}}, 0);
        System.out.printf("chair number = %d", ans);
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Comparator<int[]> comp = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(times, comp);
        System.out.println(Arrays.deepToString(times));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<times.length;i++){
            pq.add(i);
            set.add(times[i][0]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for(int i =0; i< 100001;i++){
            if(map.containsKey(i)){
                pq.addAll(map.remove(i));
            }
            int seat = pq.peek();
            if(set.remove(i)){
                pq.poll();
                map.putIfAbsent(times[count][1], new ArrayList<>());
                map.get(times[count][1]).add(seat);
                count++;
            }
            if(i == targetArrival)
                return seat;
        }


        return 0;
    }
}
