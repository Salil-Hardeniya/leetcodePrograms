package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToReach3342 {
    public static void main(String[] args) {
        MinTimeToReach3342 minTimeToReach3342 = new MinTimeToReach3342();
        int[][] array = {{0,4},{4,4}};
        int ans = minTimeToReach3342.minTimeToReach(array);
        System.out.println(ans);
    }
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;
    int[][] time;
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        visited = new boolean[n][m];
        time = new int[n][m];
        Arrays.stream(time).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        time[0][0] = 0;
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        pq.add(new int[]{0,0,0,0});
        int mod = 1;
        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            int ox = temp[0];
            int oy = temp[1];
            int currentTime = temp[2];
            int next = temp[3];
            if(visited[ox][oy])
                continue;
            visited[ox][oy] = true;
            for(int[] d : dir){
                int x = ox + d[0];
                int y = oy + d[1];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y])
                    continue;

                int newTime;
                if (moveTime[x][y] <= currentTime) {
                    newTime= currentTime + 1 + next;
                } else {
                    newTime = moveTime[x][y] + 1 + next;
                }
                if(newTime < time[x][y]){
                    time[x][y] = newTime;
                    pq.add(new int[]{x,y,newTime,next^1});
                }
            }
            mod = 1^mod;
        }

        return time[n-1][m-1];
    }
}
