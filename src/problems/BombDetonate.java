package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class BombDetonate {
    public static void main(String[] args) {
        int[][] bomb =  {{2,1,3},{6,1,4}};
        int n = bomb.length;
        int[][] dist = new int[n][n];
        int[] visited = new int[n];

        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> aasd = new HashSet<>();
        aasd.add(2131);

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int x1 = bomb[i][0];
                int y1 = bomb[i][1];
                int x2 = bomb[j][0];
                int y2 = bomb[j][1];
                int di = (int) Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
                dist[i][j] = di;
                dist[j][i] = di;
            }
        }

        int max = 1;
        for(int i = 0;i < n; i++){
            Arrays.fill(visited, -1);
            q.offer(i);
            visited[i] = 1;
            int count = 1;
            while(!q.isEmpty()){
                int bom = q.poll();
                for(int j = 0;j<n;j++){
                    if(visited[j] != -1)
                        continue;
                    if(bomb[bom][2] >= dist[j][bom]){
                        q.offer(j);
                        visited[j]  = 1;
                        ++count;
                    }
                }
            }
            if(max < count){
                max = count;
            }
        }
        System.out.println(max);
    }
}
